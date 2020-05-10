package com.pmo.pfc.common.util.excel;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.List;

public class ExcelTest {

    @Test
    public void testReadExcel(){

        try (InputStream is = new FileInputStream("E:\\note\\test-data-x.xlsx")) {
            ExcelConsumer excelConsumer = new ExcelConsumer(is);
            excelConsumer.addListener(new ExcelParser.AbstractTextRowListener() {
                @Override
                public void poll(String sheet, int currentRowNum, List<String> cells) {
                    System.out.println(MessageFormat.format("sheet:{0},currentRowNum：{1},cells:[{2}]",
                            sheet, currentRowNum, StringUtils.join(cells.stream().toArray(),",")));
                }
            });
            excelConsumer.process();
        } catch (SAXException | IOException | OpenXML4JException e) {
            e.printStackTrace();
        }

    }

}
