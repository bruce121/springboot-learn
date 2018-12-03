package com.bruce121.controller;

import com.bruce121.producer.MyMessageProducer;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.Destination;

/**
 * Author: Bruce121
 * Date: 2018-11-29
 */
@Controller
public class SendMessageController {

    @Autowired
    private MyMessageProducer myMessageProducer;

    @ResponseBody
    @GetMapping("/demo/send/{message}")
    public String sendMessage(@PathVariable("message") String message) {
        Destination destination = new ActiveMQQueue("queue-one");
        myMessageProducer.sendMessage(destination, message);
        return "success";
    }
}
