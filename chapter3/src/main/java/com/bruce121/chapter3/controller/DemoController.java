package com.bruce121.chapter3.controller;

import com.bruce121.chapter3.entity.Bruce121;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Bruce121
 * Date: 2018-10-10
 */
@RestController
public class DemoController {
    @Autowired
    Bruce121 demoBruce;

    @RequestMapping(path = "/demoBruce", method = RequestMethod.GET)
    public String demoBruce(){
        return demoBruce.getName() + " : " + demoBruce.getWebsite();
    }

    @Value("${com.bruce121.demo.name}")
    private String name;
    @Value("${com.bruce121.demo.website}")
    private String website;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String index(){
        return name + " : " + website;
    }

    @Autowired
    private Bruce121 beanBruce;

    @RequestMapping(path = "/beanBruce", method = RequestMethod.GET)
    public String beanBruce(){
        return beanBruce.getName() + " : " + beanBruce.getWebsite();
    }

    @Autowired
    private Bruce121 beanBruce2;

    @RequestMapping(path = "/beanBruce2", method = RequestMethod.GET)
    public String beanBruce2(){
        return beanBruce2.getName() + " : " + beanBruce2.getWebsite();
    }

    @Autowired
    private Bruce121 beanBruce3;

    @RequestMapping(path = "/beanBruce3", method = RequestMethod.GET)
    public String beanBruce3(){
        return beanBruce3.getName() + " : " + beanBruce3.getWebsite();
    }

}

