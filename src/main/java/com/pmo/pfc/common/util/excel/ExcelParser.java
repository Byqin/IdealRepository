package com.pmo.pfc.common.util.excel;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.xml.sax.SAXException;

public interface ExcelParser {

	/**
	 * ִ
	 * @throws IOException
	 * @throws SAXException
	 * @throws OpenXML4JException
	 */
	void process() throws IOException,SAXException,OpenXML4JException;
	
	/**
	 * 设置监听
	 * @param rowListener
	 */
	void setListener(AbstractTextRowListener rowListener);
	
	/**
	 * 获取所有sheet名称
	 * @return
	 */
	Set<String> getSheetNames();
	
	int getStartRow();
	
	void setStartRow(int startRow);
	
	/**
	 * 获取FilterSheet
	 * @return
	 */
	Set<String> getFilterSheets();
	
	void setFilterSheets(Set<String> filterSheet);
	
	void addFilterSheets(String filterSheet);
	
	/**
	 *
	 * @param sheet sheet名称
	 * @param currentRowNum 当前行数
	 * @param cells 列集合
	 */
	void send(String sheet, int currentRowNum, List<String> cells);
	
	
	abstract class AbstractTextRowListener {
		
		public abstract void poll(String sheet, int currentRowNum, List<String> cells);
		
	}
}
