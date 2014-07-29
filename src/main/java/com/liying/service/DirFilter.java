package com.liying.service;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;


public class DirFilter {
    
    public static void main(final String[] args) {
        
        File path = new File("E:\\test");
        String[] list = null;
        if(args.length == 0){
            list = path.list();
        } else {
            list = path.list(new FilenameFilter() {
                
                public boolean accept(File dir, String name) {
                    Pattern pattern = Pattern.compile(args[0]);
                    return pattern.matcher(name).matches();
                }
            });
        }
        for(String file : list){
            System.out.println(file);
        }
    }
}

