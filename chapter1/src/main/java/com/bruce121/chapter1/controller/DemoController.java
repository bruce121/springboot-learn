package com.bruce121.chapter1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Bruce121
 * Date: 2018-10-09
 */
@RestController
public class DemoController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World!";
    }

}
