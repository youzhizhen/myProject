package com.liying;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.google.common.collect.Lists;
import com.liying.util.FastExcel;


public class Test {
    
    @SuppressWarnings("resource")
    public static void main(String[] args) throws InvalidFormatException, IOException {
        FastExcel fastExcel = new FastExcel("D:/test2.xlsx", "afasd");
        fastExcel.setSheetName("Sheet1");
        /*List<MyTest> tests = fastExcel.parse(MyTest.class);
        if(null != tests && !tests.isEmpty()) {
            for(MyTest myTest : tests) {
                System.out.println(myTest.toString());
            }
        } else {
            System.out.println("没有数据");
        }*/
        
        List<MyTest> tests = Lists.newArrayList();
        MyTest t = new MyTest();
        t.setName("test1");
        t.setPhone("123456");
        
        MyTest t1 = new MyTest();
        t1.setName("test2");
        t1.setPhone("12345678");
        tests.add(t1);
        tests.add(t);
        fastExcel.createExcel(tests);
    }

}
