package com.liying.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liying.model.PartPicture;
import com.liying.service.BusinessService;

@Controller
@RequestMapping("/business")
public class BusinessController {
    
    @Resource
    private BusinessService businessService;
    
    @RequestMapping("test")
    @ResponseBody
    public List<PartPicture> testSql(String name) throws SQLException{
        System.out.println(name);
        return businessService.getParts();
    }

}
