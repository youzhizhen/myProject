package com.liying.service;

import org.springframework.stereotype.Service;


@Service
public class UserService {

    private String name;
    private int age;
    
    public String ToString(){
        return "name:" + name + ",age:" + age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
