package com.bruce121.handler;

import com.bruce121.producer.MyMessageProducer;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.Destination;

@Controller
@RequestMapping(path = "/my-activemq")
@ConditionalOnProperty(prefix = "my-activemq", value = "enabled", havingValue = "true", matchIfMissing = false)
public class MyMessageController {

    @Value("${my-activemq.default_queue:test.queue}")
    private String defaultQueue;

    @Autowired
    private MyMessageProducer messageProducer;

    @RequestMapping(path = "/send/{message}", method = {RequestMethod.GET})
    @ResponseBody
    public String testSendMessage(@PathVariable String message) {
        Destination destination = new ActiveMQQueue(defaultQueue);
        // 发送消息
        messageProducer.sendMessage(destination, message);
        return "success";
    }
}
