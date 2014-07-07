package com.liying.service;

import java.util.ArrayList;
import java.util.List;

public class MuilThreadTest implements Runnable{

    private List<String> modelCodes = new ArrayList<String>();
    private int index;
    
    public MuilThreadTest(List<String> modelCodes, int index){
        this.modelCodes = modelCodes;
        this.index = index;
    }

    public void run() {
        for(String modelCode  : modelCodes){
            System.out.println("thread-"+ index+":" +modelCode);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }  
    }
}
