package com.bruce121.chapter4.config;

import com.bruce121.chapter4.entity.Bruce121;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import lombok.Getter;
import lombok.Setter;

/**
 * Author: Bruce121
 * Date: 2018-10-11
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "com.bruce121.own")
@PropertySource("classpath:app.properties")
public class BeanOwnConfig {

    private String name;
    private String website;

    @Autowired
    private Environment env;

    @Bean
    public Bruce121 beanBruce3() {
        // String name = env.getProperty("com.bruce121.own.name"); // own-diy
        // String website = env.getProperty("com.bruce121.own.website"); // own-diy-website
        return new Bruce121(name, website);
    }

}
