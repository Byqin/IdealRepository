package com.pmo.pfc.common.util.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ooxml.util.SAXHelper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

@Slf4j
public class XlsxParser implements ExcelParser, XSSFSheetXMLHandler.SheetContentsHandler {

	private final OPCPackage xlsxPackage;
	private List<String> rowData = new LinkedList<>();
	
	private Set<String> sheetNames = new HashSet<>(); 
	private Set<String> filterSheets = new HashSet<>(); 
	
	private boolean firstCellOfRow;
	private int currentRow = -1 ;
	private int currentCol;
	private int startRow = 0;
	private AbstractTextRowListener rowListener;
	private String currentSheetName;
	
	public XlsxParser(OPCPackage pkg) {
		this.xlsxPackage = pkg;
	}
	
	public XlsxParser(InputStream in) throws IOException,InvalidFormatException {
		 this(OPCPackage.open(in));
	}
	
	public XlsxParser(File file) throws IOException,InvalidFormatException {
		 this(new FileInputStream(file));
	}
	
	private void outputMissingRows(int startRow , int endRow ) {
		for (int thisRow = startRow	; thisRow < endRow; thisRow++) {
			send(currentSheetName, thisRow, rowData);
		}
	}
	
	@Override
	public void process() throws IOException, SAXException, OpenXML4JException {
		ReadOnlySharedStringsTable strings = new ReadOnlySharedStringsTable(this.xlsxPackage);
		XSSFReader xssfReader = new XSSFReader(xlsxPackage);
		StylesTable styles = xssfReader.getStylesTable();
		XSSFReader.SheetIterator iter = (XSSFReader.SheetIterator)xssfReader.getSheetsData();
		while(iter.hasNext()) {
			try(InputStream stram = iter.next()){
				String sheetName = iter.getSheetName();
				currentSheetName = sheetName;
				sheetNames.add(currentSheetName);
				if(CollectionUtils.isEmpty(filterSheets) || filterSheets.contains(currentSheetName)) {
					processSheet(styles, strings, this, stram);
				}
			}
		}
	}

	@Override
	public void setListener(AbstractTextRowListener rowListener) {
		this.rowListener = rowListener;
	}

	@Override
	public Set<String> getSheetNames() {
		return this.sheetNames;
	}

	@Override
	public int getStartRow() {
		return this.startRow;
	}

	@Override
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	@Override
	public Set<String> getFilterSheets() {
		return this.filterSheets;
	}

	@Override
	public void setFilterSheets(Set<String> filterSheet) {
		this.filterSheets = filterSheet;
	}

	@Override
	public void addFilterSheets(String filterSheet) {
		this.filterSheets.add(filterSheet);
	}

	@Override
	public void send(String sheet, int currentRowNum, List<String> cells) {
		if(currentRowNum >= startRow) {
			rowListener.poll(sheet, currentRowNum, cells);
		}
	}


	@Override
	public void cell(String cellReference, String formattedValue, XSSFComment comment) {
		 if(firstCellOfRow) {
			 firstCellOfRow = false;
		 }
		 
		 //garacefully handle missing CellRef here in a similar way as XSSFCell does 
		 if(cellReference == null) {
			 cellReference = new CellAddress(currentRow,currentCol).formatAsString();
		 }
		 //Did we miss ant cell ��
		 int thisCol = (new CellReference(cellReference)).getCol();
		 int missedCols = thisCol - currentCol -1 ;
		 for (int i = 0; i < missedCols; i++) {
			rowData.add("");
		}
		 currentCol = thisCol;
		 rowData.add(formattedValue);
	}

	@Override
	public void endRow(int rowNum) {
		send(currentSheetName, currentRow, rowData);
		rowData.clear();
	}

	@Override
	public void startRow(int rowNum) {
		 //If there were gaps , output the missing rows 
		outputMissingRows(currentRow +1, rowNum);
		// Prepare for this row 
		firstCellOfRow = true;
		currentRow = rowNum;
		currentCol = -1;
	}

	
	@Override
	public void headerFooter(String text , boolean isHeader , String tagName) {
		log.info("text {} , isHeader {} , tagName{}",text,isHeader,tagName);
	}
	
	public void processSheet(
			StylesTable styles, // 列格式的设置等
			ReadOnlySharedStringsTable strings, // 数据源
			XSSFSheetXMLHandler.SheetContentsHandler sheetHandler, //数据处理模板
			InputStream sheetInputStream // 当前操作的sheet
					) throws IOException,SAXException {
		DataFormatter formatter  = new DataFormatter(); // 用于数据格式化
		InputSource sheetSource = new InputSource(sheetInputStream);

		try {
			XMLReader sheetParser = SAXHelper.newXMLReader();
			ContentHandler handler = new XSSFSheetXMLHandler(styles, strings, sheetHandler, formatter,false);
			sheetParser.setContentHandler(handler);
			sheetParser.parse(sheetSource);
		}catch(ParserConfigurationException e) {
			throw new RuntimeException("SAX parser appars to be broken - " + e.getMessage());
		}
	}


	/**
	 * Utility to identify builtin formats. Now can handle user defined data formats also.
	 * The following is a list of the formats as returned by this class.
	 *
	 * styles.getStyleAt(1).getDataFormat() 对应的值。
	 * 以下数值可能不正确
	 *
	 *
	 * 0, "General"
	 * 1, "0"
	 * 2, "0.00"
	 * 3, "#,##0"
	 * 4, "#,##0.00"
	 * 5, "($#,##0_);($#,##0)"
	 * 6, "($#,##0_);[Red]($#,##0)"
	 * 7, "($#,##0.00);($#,##0.00)"
	 * 8, "($#,##0.00_);[Red]($#,##0.00)"
	 * 9, "0%"
	 * 0xa, "0.00%"
	 * 0xb, "0.00E+00"
	 * 0xc, "# ?/?"
	 * 0xd, "# ??/??"
	 * 0xe, "m/d/yy"
	 * 0xf, "d-mmm-yy"
	 * 0x10, "d-mmm"
	 * 0x11, "mmm-yy"
	 * 0x12, "h:mm AM/PM"
	 * 0x13, "h:mm:ss AM/PM"
	 * 0x14, "h:mm"
	 * 0x15, "h:mm:ss"
	 * 0x16, "m/d/yy h:mm"
	 * // 0x17 - 0x24 reserved for international and undocumented 0x25, "(#,##0_);(#,##0)"
	 *
	 * 0x26, "(#,##0_);[Red](#,##0)"
	 *
	 * 0x27, "(#,##0.00_);(#,##0.00)"
	 *
	 * 0x28, "(#,##0.00_);[Red](#,##0.00)"
	 *
	 * 0x29, "_(*#,##0_);_(*(#,##0);_(* \"-\"_);_(@_)"
	 *
	 * 0x2a, "_($*#,##0_);_($*(#,##0);_($* \"-\"_);_(@_)"
	 *
	 * 0x2b, "_(*#,##0.00_);_(*(#,##0.00);_(*\"-\"??_);_(@_)"
	 *
	 * 0x2c, "_($*#,##0.00_);_($*(#,##0.00);_($*\"-\"??_);_(@_)"
	 *
	 * 0x2d, "mm:ss"
	 *
	 * 0x2e, "[h]:mm:ss"
	 *
	 * 0x2f, "mm:ss.0"
	 *
	 * 0x30, "##0.0E+0"
	 *
	 * 0x31, "@" - This is text format.
	 *
	 * 0x31 "text" - Alias for "@"
	 */

}
