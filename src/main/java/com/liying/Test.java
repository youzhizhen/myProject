package com.liying;
import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactoryUtils;


public class Test extends BeanFactoryUtils{
    
    
    private static transient final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) throws FileNotFoundException {
        
        String name = "liying";
        int age = 10;
        logger.info("name: {}, age : {}", name, age);
        
    }

}
