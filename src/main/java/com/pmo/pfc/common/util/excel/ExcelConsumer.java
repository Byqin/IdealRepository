package com.pmo.pfc.common.util.excel;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.xml.sax.SAXException;

public class ExcelConsumer {

	private ExcelParser parser;
	
	public ExcelConsumer (InputStream in) throws IOException,InvalidFormatException {
		InputStream is = FileMagic.prepareToCheckMagic(in);
		FileMagic fm = FileMagic.valueOf(is);
		switch (fm) {
			case OLE2:
				POIFSFileSystem fs = new POIFSFileSystem(is);
				parser = new XlsParser(fs);
				break;
			case OOXML:
				parser = new XlsxParser(OPCPackage.open(is));
				break;
			default:
					throw new InvalidFormatException("Your InputStream was neither an OLE2 stream ,nor na OOXML stream");
		}
	}
	
	public void skipHeader() {
		parser.setStartRow(1);
	}
	
	public void process() throws IOException, SAXException, OpenXML4JException {
		parser.process();
	}
	
	public void addListener(ExcelParser.AbstractTextRowListener listener) {
		parser.setListener(listener);
	}
	
}
