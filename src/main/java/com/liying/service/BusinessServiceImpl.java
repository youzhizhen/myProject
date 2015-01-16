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
        return businessDao.list();
    }

}
