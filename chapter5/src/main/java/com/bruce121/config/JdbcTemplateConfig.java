package com.bruce121.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Properties;

import javax.sql.DataSource;

/**
 * Author: Bruce121
 * Date: 2018-11-01
 */
@Configuration
public class JdbcTemplateConfig {

    // 创建一个构造Druid数据源所需要的Properties
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public Properties properties() {
        return new Properties();
    }

    // 使用上面的Properties构造一个DataSource
    @Bean
    public DataSource druidDataSource() throws Exception {
        return DruidDataSourceFactory.createDataSource(properties());
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate jdbcTemplate() throws Exception{
        return new JdbcTemplate(druidDataSource());
    }

    // 构建第二个数据源所需要的配置
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.two")
    public Properties secondaryProperties() {
        return new Properties();
    }

    @Bean("secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate() throws Exception{
        return new JdbcTemplate(DruidDataSourceFactory.createDataSource(secondaryProperties()));
    }

}
