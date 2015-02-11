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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.liying.model.PartPicture;
import com.liying.model.User;
import com.liying.service.BusinessService;

@Controller
@RequestMapping("/business")
public class BusinessController {

    @Resource
    private BusinessService businessService;
    
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.POST, value = "test", headers = "Accept=application/json")
    @ResponseBody
    public User testSql(@RequestBody User userParam) throws SQLException {
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> entity = new HttpEntity<User>(userParam, headers);
        ResponseEntity<User> response = restTemplate.exchange("http://localhost:8080/sih-epc/account/test", HttpMethod.POST, entity, User.class);
        User user = response.getBody();
        // handle the employees
        return user;
    }

}
