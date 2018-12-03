package com.bruce121;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;

@SpringBootApplication(exclude = {JmsAutoConfiguration.class, ActiveMQAutoConfiguration.class})
public class MyActivemqSampleAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyActivemqSampleAppApplication.class, args);
	}
}
