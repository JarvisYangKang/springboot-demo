package com.jarvis.demo.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.jarvis.demo.common.datasource.DynamicRoutingDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangkang
 * @version 2020年01月19日
 * @since
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "a")
    @ConfigurationProperties(prefix = "spring.datasource.druid.a")
    public DataSource aDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "b")
    @ConfigurationProperties(prefix = "spring.datasource.druid.b")
    public DataSource bDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource(){
        DynamicRoutingDataSource dynamicRoutingDataSource = new DynamicRoutingDataSource();
        Map<Object, Object> dataSourceMap = new HashMap<>(16);
        dataSourceMap.put("a", aDataSource());
        dataSourceMap.put("b", bDataSource());
        dynamicRoutingDataSource.setDefaultTargetDataSource(aDataSource());
        dynamicRoutingDataSource.setTargetDataSources(dataSourceMap);
        return dynamicRoutingDataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }

}
