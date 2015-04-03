package com.liying.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.liying.dao.BusinessDao;
import com.liying.model.PartPicture;

@Service
public class BusinessServiceImpl implements BusinessService {
    @Resource
    private BusinessDao businessDao;


    public void doSomething(String name, int age) {
        System.out.println("this is do  something...");
        
    }

    public List<String> batchInsert() {
        
        List<PartPicture> list = Lists.newArrayList();
        PartPicture p1 = new PartPicture();
        p1.setPartNO("11");
        
        PartPicture p2 = new PartPicture();
        p2.setPartNO("22");
        
        list.add(p1);
        list.add(p2);
        return businessDao.batchInsert(list);
    }

}
