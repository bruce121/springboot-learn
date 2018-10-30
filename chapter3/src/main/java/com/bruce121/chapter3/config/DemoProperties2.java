package com.bruce121.chapter3.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * Author: Bruce121
 * Date: 2018-10-11
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "com.bruce121.demo2")
public class DemoProperties2 {
    private String name;
    private String website;
}
