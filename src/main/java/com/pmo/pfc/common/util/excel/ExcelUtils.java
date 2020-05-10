package com.pmo.pfc.common.util.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.cqfae.pmo.pfc.project.web.handler.GenericPushSocketMesageHandler;

import javafx.util.Pair;

public class ExcelUtils {

	public static final Logger logger = LoggerFactory.getLogger(ExcelUtils.class);
	
	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static final int MAX_WRITE_ROW_NUM = 100;
	
	private ExcelUtils() {}
	
	public static ExcelWriter createExcelWriter() {
		return new ExcelWriter();
	}
	
	public static ExcelReader createExcelReader() {
		return new ExcelReader();
	}
	
	public static Set<String> getSheetNames(String fileName){
		Set<String> names = new LinkedHashSet<>();
		try(InputStream in = new FileInputStream(fileName)){
			Workbook wb = WorkbookFactory.create(in);
			names = getSheetNames(wb);
		}catch(FileNotFoundException e) {
			logger.error("文件{}未找到",fileName,e);
		}catch(IOException e) {
			logger.error("文件{}读取失败",fileName,e);
		}
		return names;
	}
	
	public static Set<String> getSheetNames(Workbook wb){
		Set<String> names = new LinkedHashSet<>();
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			String name = wb.getSheetName(i);
			names.add(name);
		}
		return names;
	}
	
	public static Pair<String,List<List<String>>> readSheet(Sheet sheet,FormulaEvaluator evaluator
																				,Integer startReadRowNum , List<Integer> selectColumnIdx){
		List<List<String>> rows = new  LinkedList<>();
		String sheetName = sheet.getSheetName();
		Integer firstRowNum = sheet.getFirstRowNum();
		Integer lastRowNum  = sheet.getLastRowNum();
		if(startReadRowNum >firstRowNum && startReadRowNum <lastRowNum) {
			firstRowNum = startReadRowNum;
		}
		Iterator<Row> rowIterator = sheet.rowIterator();
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
			int rowIdx = row.getRowNum();
			if(rowIdx < firstRowNum) {
				// 当前行数比firstRowNum小就跳过，继续下一行，即从firstRowNum行处开始取数
				continue;
			}
			rows.add(readRow(row, evaluator, selectColumnIdx));
		}
		return new Pair<>(sheetName,rows);
	}
	
	/**
	 * 读取一行数据
	 * @param row
	 * @param evaluator
	 * @param selectColumnIdx
	 * @return
	 */
	public static List<String> readRow(Row row,FormulaEvaluator evaluator , List<Integer> selectColumnIdx){
		List<String> res = new LinkedList<>();
		for (int cellIdx = 0; cellIdx < row.getLastCellNum(); cellIdx++) {
			Cell cell = row.getCell(cellIdx);
			if(CollectionUtils.isNotEmpty(selectColumnIdx) && ! selectColumnIdx.contains(cellIdx)){
				// 该列未在选择的列中，跳过
				continue;
			}
			res.add(readCell(cell,evaluator));
		}
		return res;
	}
	
	public static String readCell(Cell cell,FormulaEvaluator evaluator) {
		String res = null;
		if(Objects.isNull(cell)) {
			return null;
		}
		switch (cell.getCellType()) {
			case STRING:
				res = cell.getRichStringCellValue().toString();
				break;
			case BOOLEAN:
				res = String.valueOf(cell.getBooleanCellValue());
				break;
			case FORMULA: //公式类型
				CellValue value = evaluator.evaluate(cell);
				CellType cellValueType = value.getCellType();
				switch (cellValueType) {
					case NUMERIC:
						BigDecimal cellValue = BigDecimal.valueOf(value.getNumberValue());
						res = cellValue.stripTrailingZeros().toPlainString();
						break;
					case STRING:
						res = value.getStringValue();
						break;
					case BOOLEAN:
						res = cell.getBooleanCellValue() ? "TRUE" :"FALSE";
						break;
					case ERROR:
						res = ErrorEval.getText(value.getErrorValue());
						break;
					default:
						res = "< error unexpected cell type " + cellValueType +">";
						break;
					}
				//res = cell.getRichStringCellValue().toString();
				break;
			case NUMERIC:
				if(org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
					res = String.valueOf(SDF.format(cell.getDateCellValue()));
				}else {
					BigDecimal cellValue = BigDecimal.valueOf(cell.getNumericCellValue());
					res = cellValue.stripTrailingZeros().toPlainString();
				}
				//res = cell.getRichStringCellValue().toString();
				break;
			case BLANK:
			case ERROR:
			case _NONE:
				res = null;
				break;
			default:
				res  = cell.getRichStringCellValue() == null ? null :cell.getRichStringCellValue().toString();
				break;
		}
		return res;
	}
	
	/**
	 * 将数据写入excel
	 * @param wb 工作簿
	 * @param sheet sheet模板
	 * @param data 数据
	 */
	public static void writeToExcel(Workbook wb ,String sheet,List<List<?>> data) {
		Sheet sh  = wb.createSheet(sheet);
		writeSheet(sh,data);
	}
	
	/**
	 * 将数据写入sheet
	 * @param sheet sheet模板
	 * @param data 数据
	 */
	public static void writeSheet(Sheet sheet, List<List<?>> data) {
		for (int i = 0; i < data.size(); i++) {
			Row row = sheet.createRow(i);
			writeRow(row, data.get(i));
		}
	}

	/**
	 * 写入行数据
	 * @param row  行
	 * @param data 数据
	 */
	public static void writeRow(Row row , List<?> data) {
		for (int i = 0; i < data.size(); i++) {
			Cell cell = row.createCell(i);
			writeCell(cell, data.get(i));
		}
	}
	
	/**
	 * 创建excel
	 * @param fileName 文件名称
	 * @return
	 */
	public static Workbook createWorkBook(String fileName) {
		Workbook res = null;
		if(StringUtils.isBlank(fileName)) {
			return res;
		}
		ExcelType excelType = ExcelType.getByName(fileName);
		switch (excelType) {
			case XLS:
				res = new HSSFWorkbook();
				break;
			case XLSX:
				res = new SXSSFWorkbook(MAX_WRITE_ROW_NUM);
				// 设置文件压缩gzip文件
				((SXSSFWorkbook)res).setCompressTempFiles(true);
				break;
			default:
				break;
		}
		return res;
	}
	
	private static void writeCell(Cell cell ,Object data) {
		if(data instanceof Number) {
			if(data instanceof Float || data instanceof Double) {
				cell.setCellType(CellType.NUMERIC);
				cell.setCellValue((Double) data);
			}else {
				cell.setCellType(CellType.STRING);
				cell.setCellValue(String.valueOf(data));
			}
		}else if(data instanceof Date) {
			cell.setCellValue((Date) data);
		}else if (data instanceof Boolean ) {
			cell.setCellType(CellType.BOOLEAN);
			cell.setCellValue( (Boolean)data);
		}else {
			cell.setCellType(CellType.STRING);
			cell.setCellValue(Objects.toString(data,""));
		}
	}
	
	
	public enum ExcelType{
		XLS(1,"xls"),
		XLSX(2,"xlsx"),
		OTHER(3,"Unknown");
		
		Integer code;
		
		String name;
		
		private ExcelType(Integer code,String name) {
			this.code = code;
			this.name = name;
		}

		public Integer getCode() {
			return code;
		}

		public String getName() {
			return name;
		}
		
		public static ExcelType getByCode(Integer code) {
			ExcelType res = null ;
			for(ExcelType item:ExcelType.values()) {
				if(Objects.equals(item.getCode(), code)) {
					res = item;
					break;
				}
			}
			return res;
		}
		
		public static ExcelType getByName(String name) {
			ExcelType res = null ;
			for(ExcelType item:ExcelType.values()) {
				if(StringUtils.endsWithIgnoreCase(name, item.getName())) {
					res = item;
					break;
				}
			}
			return res;
		}
	}


	public static class ExcelWriter{
		private File file ;
		private String fileName;
		private OutputStream out;
		
		private Map<String, List<List<?>>> preWriteDatas = new LinkedHashMap<>();
		
		public ExcelWriter() {}
		
		public ExcelWriter(String fileName) {
			this.file = new File(fileName);
		}
		
		public ExcelWriter setFileName(String fileName)  {
			this.fileName = fileName;
			if(Objects.isNull(out)) {
				this.file  = new File(fileName);
			}
			return this;
		}
		
		public String getFileName() {
			return Optional.ofNullable(this.fileName).orElse("");
		}
		
		public ExcelWriter setFile(File file){
			this.file = file;
			return this;
		}
		
		public ExcelWriter setOutputStream(OutputStream out) {
			this.out = out;
			return this;
		}
		
		/**
		 * 添加sheet数据
		 * @param datas
		 * @return
		 */
		public ExcelWriter addData(Pair<String,List<List<?>>>... datas) {
			 for(Pair<String,List<List<?>>> sheetData:datas) {
				 preWriteDatas.put(sheetData.getKey(), sheetData.getValue());
			 }
			 return this;
		}
		
		
		public ExcelWriter addData(String sheet,List<List<?>> data) {
			preWriteDatas.put(sheet, data);
			return this;
		}
		
		/**
		 * 添加sheet数据模板以及对应的数据
		 * @param sheet sheet模板
		 * @param datas 数据
		 * @param toList 将datas转换成List函数
		 * @return
		 */
		public <T> ExcelWriter addData(String sheet,Collection<T> datas,Function<T, List<?>> toList) {
			List<List<?>> list = datas.stream().map(toList).collect(Collectors.toList());
			preWriteDatas.put(sheet, list);
			return this;
		}
		
		public ExcelWriter appendData(String sheet,List<?> data) {
			List<List<?>> cache = null;
			if(preWriteDatas.containsKey(sheet)) {
				cache = preWriteDatas.get(sheet);
			}else {
				cache = new LinkedList<>();
				preWriteDatas.put(sheet, cache);
			}
			cache.add(data);
			return this;
		}
		
		private OutputStream getOutputStream() throws FileNotFoundException {
			return Objects.isNull(out) ? new FileOutputStream(file):out;
		}
		
		/**
		 * ִ��д����
		 */
		public void write() {
			String fileName = getFileName();
			try(Workbook wb = createWorkBook(fileName);OutputStream out = getOutputStream()){
				if(Objects.isNull(wb)) {
					throw new RuntimeException(String.format("创建\"%s\"失败", fileName));
				}
				preWriteDatas.entrySet().forEach(kv->writeToExcel(wb, kv.getKey(), kv.getValue()));
				wb.write(out);
				out.flush();
			}catch (FileNotFoundException e) {
				logger.error("文件{}不存在",fileName,e);
			}catch (IOException e) {
				logger.error("写入excel文件{}失败",fileName,e);
			}
		}
	}
	
	
	
	public static class ExcelReader{
		
		private File file ;
		private String fileName;
		private InputStream in;
		private List<String> sheets = new LinkedList<>();
		private Integer startRowNum = -1;
		private List<Integer> selectColumnIdx ;
		
		public ExcelReader() {}
		
		public ExcelReader(String fileName) {
			this.file = new File(fileName);
		}
		
		public ExcelReader setFileName(String fileName)  {
			this.fileName = fileName;
			if(Objects.isNull(in)) {
				this.file  = new File(fileName);
			}
			return this;
		}
		
		public String getFileName() {
			return Optional.ofNullable(this.fileName).orElse("");
		}

		public ExcelReader setFile(File file) {
			this.file = file;
			return this;
		}

		public ExcelReader setIn(InputStream in) {
			this.in = in;
			return this;
		}
		
		/**
		 * 添加sheet
		 * @param sheet
		 * @return
		 */
		public ExcelReader addSheet(String sheet) {
			this.sheets.add(sheet);
			return this;
		}
		
		/**
		 * 添加sheet集合
		 * @param sheets
		 * @return
		 */
		public ExcelReader addSheet(String... sheets) {
			return addSheet(Stream.of(sheets).collect(Collectors.toList()));
		}
		
		
		public ExcelReader addSheet(List<String> sheets) {
			this.sheets.addAll(sheets);
			return this;
		}
		
		/**
		 * 跳过第一行数据
		 * @return
		 */
		public ExcelReader skipFirstLine() {
			this.startRowNum = 1;
			return this;
		}
		
		/**
		 * 设置数据读取的起始行，skipNum <= 0 时从第1行开始读取
		 * @param skipNum
		 * @return
		 */
		public ExcelReader setSkipLineNum(Integer skipNum) {
			return setStartRowNum(skipNum > 0 ? skipNum : 0);
		}
		
		/**
		 *  设置数据读取的起始行
		 * @param startRoNum
		 * @return
		 */
		public ExcelReader setStartRowNum(Integer startRoNum) {
			this.startRowNum = startRoNum;
			return this;
		}
		
		/**
		 * 设置需要读取的列
		 * @param selectColumnIdx
		 * @return
		 */
		public ExcelReader setSelectColumnIdx(List<Integer> selectColumnIdx) {
			this.selectColumnIdx = selectColumnIdx;
			return this;
		}

		/**
		 * 清除需要读取的列，默认读取全部列
		 * @return
		 */
		public ExcelReader clearSelectColumnIdx() {
			this.selectColumnIdx.clear();
			return this;
		}
		
		private InputStream getFileInputStream() throws FileNotFoundException {
			return Objects.isNull(in) ? new FileInputStream(file) :in;
		}
		
		/**
		 * ��ȡsheet
		 * @param readSheetFunction ithsheet sheet evaluator -> sheet.getSheetName()
		 * @return
		 */
		public <R> Map<String,R> withSheet(BiFunction<Sheet, FormulaEvaluator, R> readSheetFunction){
			String fileName = getFileName();
			Map<String,R> res = new LinkedHashMap<>();
			try(InputStream in = getFileInputStream();Workbook wb = WorkbookFactory.create(in)){
				FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
				Iterator<Sheet> sheetIterator = wb.sheetIterator();
				while(sheetIterator.hasNext()) {
					Sheet sheet = sheetIterator.next();
					if(CollectionUtils.isNotEmpty(sheets) && !sheets.contains(sheet.getSheetName())) {
						//读取的sheet未在sheets中则跳过
						continue;
					}
					R sheetData = readSheetFunction.apply(sheet, evaluator);
					res.put(sheet.getSheetName(), sheetData);
				}
			} catch (FileNotFoundException e) {
				logger.error("文件{}没有找到",fileName,e);
			}catch (IOException e) {
				logger.error("读取excel文件{}失败",fileName,e);
			}
			return res;
		}
		
		/**
		 * 读取sheet的数据
		 * @param readSheetFunction  withRow row,evaluator -> row.toString
		 * @return
		 */
		public  <R> Map<String,List<R>> withRow(BiFunction<Row, FormulaEvaluator, R> readSheetFunction){
			String fileName = getFileName();
			Map<String,List<R>> res = new LinkedHashMap<>();
			try(InputStream in = getFileInputStream();Workbook wb = WorkbookFactory.create(in)){
				FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
				Iterator<Sheet> sheetIterator = wb.sheetIterator();
				while(sheetIterator.hasNext()) {
					Sheet sheet = sheetIterator.next();
					if(CollectionUtils.isNotEmpty(sheets) && !sheets.contains(sheet.getSheetName())) {
						//读取的sheet未在sheets中则跳过
						continue;
					}
					Iterator<Row> rowIterator = sheet.rowIterator();
					List<R> sheetData = new LinkedList<>();
					while(rowIterator.hasNext()) {
						Row row = rowIterator.next();
						int rowIdx= row.getRowNum();
						if(rowIdx <startRowNum) {
							// 当前行小于开始行，则跳过
							continue;
						}
						R rowData = readSheetFunction.apply(row, evaluator);
						if(Objects.nonNull(rowData)) {
							sheetData.add(rowData);
						}
					}
					res.put(sheet.getSheetName(), sheetData);
				}
			}catch (FileNotFoundException e) {
				logger.error("文件{}没有找到",fileName,e);
			}catch (IOException e) {
				logger.error("读取excel文件{}失败",fileName,e);
			}
			return res;
		}
		
		
		public <R>  Map<String,List<List<R>>> withCell(BiFunction<Cell, FormulaEvaluator, R> readSheetFunction){
			String fileName = getFileName();
			Map<String,List<List<R>>> res = new LinkedHashMap<>();
			try(InputStream in = getFileInputStream();Workbook wb = WorkbookFactory.create(in)){
				FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
				Iterator<Sheet> sheetIterator = wb.sheetIterator();
				while(sheetIterator.hasNext()) {
					Sheet sheet = sheetIterator.next();
					if(CollectionUtils.isNotEmpty(sheets) && !sheets.contains(sheet.getSheetName())) {
						//读取的sheet未在sheets中则跳过
						continue;
					}
					Iterator<Row> rowIterator = sheet.rowIterator();
					List<List<R>> sheetData = new LinkedList<>();
					while(rowIterator.hasNext()) {
						Row row = rowIterator.next();
						int rowIdx= row.getRowNum();
						if(rowIdx <startRowNum) {
							// 当前行小于开始行，则跳过
							continue;
						}
						List<R> rowData = new LinkedList<>();
						// 循环行中的列，筛选出需要的列
						for (int cellIdx = 0; cellIdx < row.getLastCellNum(); cellIdx++) {
							Cell cell = row.getCell(cellIdx);
							if(CollectionUtils.isNotEmpty(selectColumnIdx) && !selectColumnIdx.contains(cellIdx)) {
								// 当前列未在selectColumnIdx中就跳过
								continue;
							}
							R cellData = readSheetFunction.apply(cell, evaluator);
							rowData.add(cellData);
						}
						sheetData.add(rowData);
					}
					res.put(sheet.getSheetName(), sheetData);
				}
			}catch (FileNotFoundException e) {
				logger.error("文件{}没有找到",fileName,e);
			}catch (IOException e) {
				logger.error("读取excel文件{}失败",fileName,e);
			}
			return res;
		} 
		
		public Map<String,List<List<String>>> read(){
			return withCell(ExcelUtils::readCell);
		}
	}
	
	
	

}
