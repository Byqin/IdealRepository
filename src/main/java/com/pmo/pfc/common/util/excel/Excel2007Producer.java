package com.pmo.pfc.common.util.excel;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Excel2007Producer implements Closeable {

	public static final Logger logger = LoggerFactory.getLogger(Excel2007Producer.class);
	
	private File file ;
	private String fileName;
	private OutputStream out ;
	private SXSSFWorkbook wb;
	private boolean autoCommit = true;
	private int cacheSize = 200;
	
	
	public  Excel2007Producer(String fileName) throws FileNotFoundException {
		this.fileName = fileName;
		this.file = new File(fileName);
		this.out = new FileOutputStream(file);
	}
	
	public  Excel2007Producer(File file) throws IOException {
		this.fileName = file.getCanonicalFile().getName();
		this.file = file;
		this.out = new FileOutputStream(file);
	}
	
	/**
	 * 验证excel是否存在
	 * @param sheet
	 * @return
	 */
	private boolean existSheet(String sheet) {
		return wb.getSheetIndex(sheet) != -1;
	}
	
	/**
	 * 获取sheet
	 * @param sheetName sheet名称
	 * @return
	 */
	private SXSSFSheet getSheet(String sheetName) {
		if(existSheet(sheetName)) {
			return wb.getSheet(sheetName);
		}else {
			return wb.createSheet(sheetName);
		}
	}
	
	/**
	 * 是否字段提交
	 * @return
	 */
	public boolean isAutoCommit() {
		return this.autoCommit;
	}
	
	
	public void setAutoCommit(boolean autoCommit) {
		this.autoCommit = autoCommit;
	}


	/**
	 * 获取缓存大小
	 * @return
	 */
	public int getCacheSize() {
		return cacheSize;
	}

	public void setCacheSize(int cacheSize) {
		this.cacheSize = cacheSize;
	}

	public void open()  throws IOException{
		if(Objects.isNull(out) && Objects.isNull(file) && Objects.isNull(fileName)) {
			throw new FileNotFoundException("文件不存在");
		}else if(Objects.isNull(out) && Objects.isNull(file) && Objects.nonNull(fileName)) {
			this.file = new File(fileName);
			this.out = new FileOutputStream(file);
		}else if(Objects.isNull(out) && Objects.nonNull(file)) {
			this.fileName = file.getCanonicalFile().getName();
			this.out = new FileOutputStream(file);
		}
		if(autoCommit) {
			wb = new SXSSFWorkbook(cacheSize);
		}else {
			wb = new SXSSFWorkbook(-1);
		}
		
		wb.setCompressTempFiles(true);
	}
	
	/**
	 * 向sheet中写入数据
	 * @param sheet SXSSFSheet 模板
	 * @param row 一行数据集合
	 */
	public void push(SXSSFSheet sheet , List<?> row) {
		int lastRow = sheet.getPhysicalNumberOfRows();
		SXSSFRow newRow = sheet.createRow(lastRow);
		ExcelUtils.writeRow(newRow, row);
	}
	
	public void push(String sheet , List<?> row) {
		SXSSFSheet sxssfSheet = getSheet(sheet);
		push(sxssfSheet, row);
	}
	
	public void push(Map<String ,List<?>> rows) {
		rows.entrySet().forEach(kv->{
			SXSSFSheet sxssfSheet = wb.getSheet(kv.getKey());
			push(sxssfSheet,kv.getValue());
		});
	}

	/**
	 * 批量插入数据
	 * @param sxssfSheet
	 * @param rows
	 */
	public void batchPush(SXSSFSheet sxssfSheet ,List<List<?>> rows) {
		int lastRow = sxssfSheet.getPhysicalNumberOfRows();
		for (int i = 0; i < rows.size(); i++) {
			SXSSFRow newRow = sxssfSheet.createRow(lastRow + i);
			ExcelUtils.writeRow(newRow, rows.get(i));
		}
	}
	
	/**
	 * �ύ
	 * @return
	 */
	public boolean commit() {
		boolean status = false;
		try {
			if(!autoCommit) {
				Iterator<Sheet> sheets = wb.sheetIterator();
				while(sheets.hasNext()) {
					SXSSFSheet sheet = (SXSSFSheet) sheets.next();
					sheet.flushRows();
				}
			}
			status = true;
		}catch (IOException e) {
			logger.error("提交数据失败",e);
		}
		return status;
	}
	
	@Override
	public void close() throws IOException {
			wb.write(out);
			out.close();
			wb.close();
	}

}
