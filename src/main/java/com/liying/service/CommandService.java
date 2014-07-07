package com.liying.service;

import org.springframework.stereotype.Service;

@Service
public class CommandService {
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void print(){
        name = "liying";
        System.out.println(name);
    }
    
    public int printThrowException() throws Exception {
        try{
            return 1/0;
        } catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    
    public int printThrowException1() throws Exception {
        throw new NullPointerException();
    }
    
}
