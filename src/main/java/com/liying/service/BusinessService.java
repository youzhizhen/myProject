package com.liying.service;

import java.util.List;

import com.liying.model.PartPicture;

/**
 * 
 * @author LiYing
 *
 */
public interface BusinessService {
    
    List<PartPicture> getParts();
    
    String getPartName(String partNO);

}
