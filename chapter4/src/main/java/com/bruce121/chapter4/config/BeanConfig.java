package com.bruce121.chapter4.config;

import com.bruce121.chapter4.entity.Bruce121;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: Bruce121
 * Date: 2018-10-11
 */
@Configuration
public class BeanConfig {

    @Autowired
    DemoProperties demoProperties;

    @Bean
    public Bruce121 beanBruce(DemoProperties demoProperties){
        return new Bruce121(demoProperties.getName(), demoProperties.getWebsite());
    }

    @Autowired
    DemoProperties2 demoProperties2;

    @Bean
    public Bruce121 beanBruce2(DemoProperties2 demoProperties2){
        return new Bruce121(demoProperties2.getName(), demoProperties2.getWebsite());
    }

}
