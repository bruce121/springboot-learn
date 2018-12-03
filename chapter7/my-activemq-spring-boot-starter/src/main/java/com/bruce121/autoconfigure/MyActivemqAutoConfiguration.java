package com.bruce121.autoconfigure;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

/**
 * Author: Bruce121
 * Date: 2018-11-29
 */
@Configuration
@ConditionalOnClass({ConnectionFactory.class, ActiveMQConnectionFactory.class})
@ConditionalOnMissingBean(ConnectionFactory.class)
@EnableConfigurationProperties(MyActivemqProperties.class)
@ConditionalOnProperty(prefix = "my-activemq", value = "enabled", havingValue = "true", matchIfMissing = false)
@EnableJms
public class MyActivemqAutoConfiguration {
    private static Logger logger = LoggerFactory.getLogger(MyActivemqAutoConfiguration.class);

    @Autowired
    private MyActivemqProperties properties;

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        return new ActiveMQConnectionFactory(properties.getUser(), properties.getPassword(), properties.getBrokerUrl());
    }

    @Bean
    public JmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(activeMQConnectionFactory());
        // DefaultMessageListenerContainer#setConcurrency
        factory.setConcurrency("5-10");
        // DefaultMessageListenerContainer#setRecoveryInterval
        factory.setRecoveryInterval(1000L);
        return factory;
    }

    @Bean
    @ConditionalOnMissingBean
    public JmsTemplate jmsTemplate(ActiveMQConnectionFactory connectionFactory) {
        if (connectionFactory == null) {
            logger.warn("ActiveMQConnectionFactory is null!");
        }
        return new JmsTemplate(connectionFactory);
    }

    @Bean
    @ConditionalOnMissingBean
    public JmsMessagingTemplate jmsMessagingTemplate(JmsTemplate jmsTemplate) {
        if (jmsTemplate == null) {
            logger.warn("JmsTemplate is null!");
        }
        return new JmsMessagingTemplate(jmsTemplate);
    }
}