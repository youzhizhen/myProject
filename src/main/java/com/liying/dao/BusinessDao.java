package com.liying.dao;

import java.util.List;

import com.liying.model.PartPicture;

public interface BusinessDao {
    
    List<PartPicture> list();
    
    String getPartName(String partNO);
    
    void add(PartPicture partPicture);
    
    List<String> batchInsert(List<PartPicture> list);

}
