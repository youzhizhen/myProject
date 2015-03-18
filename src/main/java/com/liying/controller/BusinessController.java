package com.liying.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Lists;
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
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<String> requestEntity = new HttpEntity<String>("liying",headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8080/sih-epc/account/test", HttpMethod.POST, requestEntity, String.class);
        return responseEntity.getBody();
    }
}
