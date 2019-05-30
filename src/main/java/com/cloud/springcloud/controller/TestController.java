package com.cloud.springcloud.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RefreshScope
@RestController
public class TestController {

    private static  final Logger logger = LoggerFactory.getLogger(TestController.class) ;
    @Value("${configValue}")
    private  String configValue ;


    @RequestMapping(value = "/add" ,method = {RequestMethod.GET,RequestMethod.POST})
    public String add(@RequestParam Integer a, @RequestParam Integer b, HttpServletRequest request) {
        logger.info(request.getRequestURL().toString());
        logger.info(configValue);
        Integer r = a + b;
        return configValue ;//"r="+r;
    }

}
