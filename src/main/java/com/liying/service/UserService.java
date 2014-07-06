package com.liying.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
@Scope("prototype")
public class UserService {

    private String name;
    private int age;
    
    public UserService() {
        System.out.println("init ...");
    }
    
    @Override
    public String toString() {
        return "name :" + name;
              
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
