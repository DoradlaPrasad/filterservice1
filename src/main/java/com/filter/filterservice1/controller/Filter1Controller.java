package com.filter.filterservice1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/filter1")
public class Filter1Controller {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public ResponseEntity<?> filterTest1() {

        ResponseEntity<String> respEnty2 = restTemplate.getForEntity("http://localhost:9999/filter2/test2", String.class);
        String str2 = null;
        if(respEnty2 != null) {
            str2 = respEnty2.getBody().toString();
        }

        return new ResponseEntity<String>("Succefully executed FILTER SERVICE1 , "+str2, HttpStatus.OK);
    }

}
