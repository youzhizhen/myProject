package com.liying.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liying.dao.BusinessDao;
import com.liying.model.PartPicture;

@Service
public class BusinessServiceImpl implements BusinessService {
    @Resource
    private BusinessDao businessDao;

    public List<PartPicture> getParts(){
        return null;
    }

    public String getPartName(String partNO) {
           
            PartPicture partPicture = new PartPicture();
            partPicture.setFilename("test");
            partPicture.setPartNO("test 5555555555555555555555");
            businessDao.add(partPicture);
            String partName = businessDao.getPartName(partNO);
            System.out.println(partName);
            return partName;  
    }

}
