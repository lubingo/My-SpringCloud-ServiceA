package com.cloud.springcloud.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {

    @RequestMapping(value = "/add" ,method = {RequestMethod.GET,RequestMethod.POST})
    public String add(@RequestParam Integer a, @RequestParam Integer b, HttpServletRequest request) {
        System.out.println(request.getRequestURL());
        Integer r = a + b;
        return "r="+r;
    }

}
