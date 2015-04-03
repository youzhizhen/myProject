package com.liying.controller;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.liying.model.User;
import com.liying.service.BusinessService;

@Controller
@RequestMapping("/business")
public class BusinessController {

   @Resource
    private BusinessService businessService;
    
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("test")
    @ResponseBody
    public String testSql(@RequestBody User userParam) throws SQLException {
        businessService.batchInsert();
        return null;
    }
}
