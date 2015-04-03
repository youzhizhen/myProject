package com.liying.service;

import java.util.List;


/**
 * 
 * @author LiYing
 *
 */
public interface BusinessService {
    
    /*List<PartPicture> getParts();
    
    String getPartName(String partNO);
    */
    void doSomething(String name, int age);
    
    List<String> batchInsert();

}
