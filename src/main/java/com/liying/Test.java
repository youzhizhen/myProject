package com.liying;
import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactoryUtils;


public class Test extends BeanFactoryUtils{
    
    
    private static transient final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) throws FileNotFoundException {
        
        System.out.println("test this sourceTree");
        //test hot fix 直接修改线上的代码
        //开发环境（master），生产环境（release-dev），线上环境（release-live）
        //hot fix 就是要自己接快速的需改线上的环境，修改之后要快速的合并到relase-dev 和master 的分支上（目的是以后合并到生产环境）
        System.out.println();
         //token
        
        //jsp token
        
        
    }

}
