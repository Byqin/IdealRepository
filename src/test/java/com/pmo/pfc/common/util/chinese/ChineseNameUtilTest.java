package com.pmo.pfc.common.util.chinese;

import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Assert;
import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class ChineseNameUtilTest {

    @Test
    public void testChinese(){

        Set<String> names =  ChineseNameUtil.getDistinctChinese(100);
        Assert.assertNotNull("names is null",names);
        System.out.println(names.size());
        StringBuilder builder = new StringBuilder("INSERT INTO ODS_PEOPLE(date,name,work_time,add_time,work_nature,is_field_per) VALUES");
        List<People> people = Lists.newArrayList();
        names.iterator().forEachRemaining((item)-> people.add(new People(item, getRandomNatures(), getRandomField())));
        int count  = 2;
        while (count-- > 0){
            people.forEach(item-> builder.append("(").append("'").append(getRandomDate()).append("','")
                    .append(item.getName()).append("',")
                    .append(getRandomNum()).append(",")
                    .append(getRandomNum()).append(",'")
                    .append(item.getNature()).append("','")
                    .append(item.getField()).append("'),\n"));
        }
        builder.replace(builder.length() -2 ,builder.length()-1,";");
        System.out.print(builder.toString());
    }

    @Test
    public void testRandomDate() throws ParseException {
        Date date = RandomDate.randomDate("2017-07-01", "2018-01-01");
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        System.out.println(new SimpleDateFormat("HH:mm").format(date));
        System.out.println(DateUtils.parseDate("2019-07-01 00:00",new String[]{"YYYY-MM-dd HH:mm"}).getTime());
        System.out.println(DateUtils.parseDate("2022-07-01 23:59",new String[]{"YYYY-MM-dd HH:mm"}).getTime());
    }


    private String getRandomDate(){
        return  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(RandomDate.randomDate("2017-07-01", "2018-01-01"));
    }

    private int getRandomNum(){
        Random random = new Random();
        return  random.nextInt(8);
    }

    List<String> workNatures = Arrays.asList("长工","短工","长工","短工");
    List<String> fieldPer = Arrays.asList("是","否","是","否");

    private String getRandomNatures(){
        Random random = new Random();
        return  workNatures.get(random.nextInt(workNatures.size() -1));
    }

    private String getRandomField(){
        Random random = new Random();
        return  fieldPer.get(random.nextInt(fieldPer.size()));
    }

    static class  People{
        private String name ;
        private String nature;
        private String field;

        public People(String name,String nature,String field){
            this.name = name;
            this.nature = nature;
            this.field = field;
        }

        public String getName(){
            return name;
        }

        public String getNature() {
            return nature;
        }

        public String getField() {
            return field;
        }
    }
}
