package com.pmo.pfc.common.util.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.hssf.eventusermodel.EventWorkbookBuilder;
import org.apache.poi.hssf.eventusermodel.FormatTrackingHSSFListener;
import org.apache.poi.hssf.eventusermodel.HSSFEventFactory;
import org.apache.poi.hssf.eventusermodel.HSSFListener;
import org.apache.poi.hssf.eventusermodel.HSSFRequest;
import org.apache.poi.hssf.eventusermodel.MissingRecordAwareHSSFListener;
import org.apache.poi.hssf.eventusermodel.dummyrecord.LastCellOfRowDummyRecord;
import org.apache.poi.hssf.eventusermodel.dummyrecord.MissingCellDummyRecord;
import org.apache.poi.hssf.model.HSSFFormulaParser;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.BoundSheetRecord;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.LabelRecord;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.NoteRecord;
import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.SSTRecord;
import org.apache.poi.hssf.record.StringRecord;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.xml.sax.SAXException;

public class XlsParser implements HSSFListener,ExcelParser{

	private POIFSFileSystem fs;
	private List<String> currentRowData = new LinkedList<>();
	
	private SSTRecord sstRecord;
	
	private List<String> sheetNames = new LinkedList<>(); 
	private Set<String> filterSheets = new HashSet<>(); 
	
	private int sheetNum = -1 ;
	private int rowNum;
	private int lastRowNumber;
	private boolean outputNextStringValue = false;
	
	private int nextRow = -1;
	
	private String currentSheetName;
	
	private int startRow = 0;
	
	/**
	 * Should we ouput the formual , or the value it has?
	 */
	private boolean outputFormulaValues = false;
	
	private FormatTrackingHSSFListener formatListener ;
	private EventWorkbookBuilder.SheetRecordCollectingListener  workbookBuildingListener;
	
	private AbstractTextRowListener rowListener;

	public XlsParser(POIFSFileSystem fs) {
		this.fs = fs;
	}
	
	public XlsParser(File file) throws IOException{
		this(new POIFSFileSystem(new FileInputStream(file)));
	}
	
	/**
	 *
	 * @return
	 */
	public boolean isOutputFormulaValues() {
		return outputFormulaValues;
	}
	
	/**
	 *
	 * @param outputFormulaValues false true
	 */
	public void setOutputFormulaValues(boolean outputFormulaValues) {
		this.outputFormulaValues = outputFormulaValues;
	}
	
	

	@Override
	public void process() throws IOException, SAXException, OpenXML4JException {
		MissingRecordAwareHSSFListener listener = new MissingRecordAwareHSSFListener(this);
		formatListener = new FormatTrackingHSSFListener(listener);
		
		HSSFEventFactory factory = new HSSFEventFactory();
		HSSFRequest request = new HSSFRequest();
		
		if(outputFormulaValues) {
			request.addListenerForAllRecords(formatListener);
		}else {
			workbookBuildingListener = new EventWorkbookBuilder.SheetRecordCollectingListener(formatListener);
			request.addListenerForAllRecords(workbookBuildingListener);
		}
		
		factory.processWorkbookEvents(request, fs);
	}

	@Override
	public void setListener(AbstractTextRowListener rowListener) {
		 this.rowListener = rowListener;
	}

	@Override
	public Set<String> getSheetNames() {
		return new HashSet<>(sheetNames);
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
		return filterSheets;
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
			 rowListener.poll(currentSheetName, currentRowNum, currentRowData);
		 }
	}

	/**
	 * Main HSSFListener method . processes evens , and outputs the 
	 * CSV as the file is processed.
	 */
	@Override
	public void processRecord(Record record) {
		 String thisText = null;
		 int thisRow = -1;
		 
		switch(record.getSid()) {
			case BoundSheetRecord.sid:
				BoundSheetRecord sr = (BoundSheetRecord) record;
				sheetNames.add(sr.getSheetname());
				break;
			case BOFRecord.sid:
				BOFRecord bof = (BOFRecord) record;
				if(bof.getType() == BOFRecord.TYPE_WORKSHEET) {
					sheetNum++;
					rowNum = -1;
					currentSheetName = sheetNames.get(sheetNum);
				}
				break;
			case SSTRecord.sid:
				sstRecord = (SSTRecord) record;
				break;
			case FormulaRecord.sid:
				FormulaRecord frec = (FormulaRecord) record;
				thisRow = frec.getRow();
				if(outputFormulaValues) {
					thisText = HSSFFormulaParser.toFormulaString(null, frec.getParsedExpression());
				}else {
					if(frec.hasCachedResultString()) {
						//Formula result is a string
						// this is stored in the next record
						outputNextStringValue = true;
						nextRow = frec.getRow();
					}else {
						thisText = formatListener.formatNumberDateCell(frec);
					}
				}
				break;
			case StringRecord.sid:
				if(outputNextStringValue) {
					//String for formula
					StringRecord srec = (StringRecord) record;
					thisText =  srec.getString();
					thisRow = nextRow;
					outputNextStringValue = false;
				}
				break;
			case LabelRecord.sid:
				LabelRecord lrec = (LabelRecord) record;
				thisRow = lrec.getRow();
				thisText = lrec.getValue();
				break;
			case LabelSSTRecord.sid:
				LabelSSTRecord lsrec = (LabelSSTRecord) record;
				thisRow = lsrec.getRow();
				if(sstRecord == null) {
					throw new IllegalStateException("No SST record found");
				}
				thisText = sstRecord.getString( lsrec.getSSTIndex()).toString();
				break;
			case NoteRecord.sid:
				NoteRecord nrec = (NoteRecord) record;
				thisRow = nrec.getRow();
				break;
			case NumberRecord.sid:
				NumberRecord numrec = (NumberRecord) record;
				thisRow = numrec.getRow();
				thisText = formatListener.formatNumberDateCell(numrec);
				break;
			default:
					break;
		}
		
		if(record instanceof MissingCellDummyRecord) {
			// �յ�Ԫ��
			MissingCellDummyRecord mc = (MissingCellDummyRecord) record;
			thisRow = mc.getRow();
			thisText = "";
		}
		
		if(thisRow > -1) {
			lastRowNumber = thisRow;
		}
		
		if(CollectionUtils.isEmpty(filterSheets) || filterSheets.contains(currentSheetName)) {
			if(thisText != null) {
				currentRowData.add(thisText);
			}
			if(record instanceof LastCellOfRowDummyRecord) {
				send(currentSheetName, lastRowNumber, currentRowData);
				currentRowData.clear();
			}
		}
		
	}
	
}
