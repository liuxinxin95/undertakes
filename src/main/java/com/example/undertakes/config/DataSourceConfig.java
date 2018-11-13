package com.example.undertakes.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

/**
 * @Author liuxinxin
 * @Description 配置jpa和mybatis读取数据源
 * @Date 2018/11/13 14:55
 * @Param
 * @Return
*/
@Configuration
public class DataSourceConfig {

    @Bean(name = "tenderDataSource")
    @Qualifier("tenderDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "epsDataSource")
    @Qualifier("epsDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.eps")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "epsJdbcTemplate")
    @Primary
    @Qualifier("epsJdbcTemplate")
    public NamedParameterJdbcTemplate primaryJdbcTemplate(
            @Qualifier("epsDataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
