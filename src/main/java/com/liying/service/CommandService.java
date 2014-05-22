package com.liying.service;

import org.springframework.stereotype.Service;

@Service
public class CommandService {
    
    private int i;

    public void setStatust(int i) {
        this.i = i;
    }

    public Object execute() {
        return "this is the commandService" + i;
    }

}
