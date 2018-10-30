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
// 如果不将该类装配成bean，可以在其他的bean中使用@EnableConfigurationProperties({DemoProperties.class})来把指定的类装配成bean
@Component
// @ConfigurationProperties可以实现将以prefix开头的配置绑定到该类的属性中
@ConfigurationProperties(prefix = "com.bruce121.demo")
public class DemoProperties {
    private String name;
    private String website;
}
