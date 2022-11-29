package com.neuedu.order.config;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    private final static Logger LOGGER = LoggerFactory.getLogger(DataSourceConfig.class);

    @Bean(name = "masterDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource masterDataSource(DataSourceProperties properties) {
        LOGGER.info("init master data source：{}", properties);
        return DataSourceBuilder.create(properties.getClassLoader())
                .type(HikariDataSource.class)
                .driverClassName(properties.determineDriverClassName())
                .url(properties.determineUrl())
                .username(properties.determineUsername())
                .password(properties.determinePassword())
                .build();
    }

    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slaveDataSource(DataSourceProperties properties) {
        LOGGER.info("init slave data source：{}", properties);
        return DataSourceBuilder.create().build();
    }

//    @Bean
//    @Primary
//    public DynamicDataSource dataSource(DataSource masterDataSource, DataSource slaveDataSource) {
//        Map<String, DataSource> targetDataSources = new HashMap<>();
//        targetDataSources.put(DataSourceEnum.MASTER.getName(), masterDataSource);
//        targetDataSources.put(DataSourceEnum.SLAVE.getName(), slaveDataSource);
//
//        return new DynamicDataSource(masterDataSource, targetDataSources);
//    }
}
