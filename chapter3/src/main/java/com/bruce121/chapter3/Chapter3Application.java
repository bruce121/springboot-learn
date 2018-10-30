package com.bruce121.chapter3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:demo-config.xml")
// @EnableConfigurationProperties({DemoProperties.class})
public class Chapter3Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter3Application.class, args);
	}
}
