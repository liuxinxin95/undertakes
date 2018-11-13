package com.example.undertakes.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author gaoyuzhe
 * @date 2018/1/16.
 */
@Configuration
@MapperScan(basePackages = {"mapper"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class MyBatisConfig {

    @Autowired
    @Qualifier("epsDataSource")
    private DataSource mybaitsDs;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        // 使用epsDataSource数据源, 连接业务库
        factoryBean.setDataSource(mybaitsDs);
        Resource[] mapperLocations = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml");
        factoryBean.setMapperLocations(mapperLocations);
        return factoryBean.getObject();

    }
    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        // 使用上面配置的Factory
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory());
        return template;
    }
}
