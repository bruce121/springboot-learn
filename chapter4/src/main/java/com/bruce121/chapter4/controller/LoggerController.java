package com.bruce121.chapter4.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Bruce121
 * Date: 2018-10-10
 */
@RestController
public class LoggerController implements InitializingBean {
    private static Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @Override
    public void afterPropertiesSet() throws Exception {
//        while (true) {
//            logger.info("这是一个死循环，为了展示日志切分。。。");
//        }
    }

    @GetMapping(path = "/print/log")
    public String pringLog() {
        logger.error("This is a log of error level.");
        logger.warn("This is a log of warn level.");
        logger.info("This is a log of info level.");
        logger.debug("This is a log of debug level.");
        logger.trace("This is a log of trace level.");
        return "success";
    }
}