package com.wd.pub.datatools.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by DimonHo on 2017/12/5.
 */
@Configuration
public class SecondaryDataSourceConfig {
    @Bean(name = "secondaryDS")
    @Qualifier("secondaryDS")
    @ConfigurationProperties(prefix="spring.datasource.secondary")
    public DataSource secondaryDataSource(){
        return DataSourceBuilder.create().build();
    }
}
