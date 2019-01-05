package com.example.orderservice.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DataSourceConfig {

    @Value("${username}")
    public String username;

    @Value("${password}")
    public String password;

    @Value("${url}")
    public String url;

    @Bean
    public DataSource dataSource() throws SQLException {
        return DataSourceBuilder.create()
                .password(password)
                .username(username)
                .url(url)
                .type(com.alibaba.druid.pool.DruidDataSource.class)
                .driverClassName("com.mysql.jdbc.Driver")
                .build();
    }
}
