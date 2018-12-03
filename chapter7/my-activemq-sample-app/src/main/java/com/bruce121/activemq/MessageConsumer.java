package com.bruce121.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

/**
 * Author: Bruce121
 * Date: 2018-11-29
 */
@Service
public class MessageConsumer {

    @JmsListener(destination = "queue-one")
    public void receiveQueue(String text){
        // TODO 根据消息进行处理
        System.out.println("Get message:" + text);
    }
}
