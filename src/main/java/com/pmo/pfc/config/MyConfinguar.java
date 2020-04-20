package com.pmo.pfc.config;

import com.alibaba.druid.pool.DruidDataSource;
import groovy.util.logging.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;

@Slf4j
@Configuration
@MapperScan(basePackages = {"com.pmo.pfc.dao.mapper"},sqlSessionFactoryRef = "sqlSessionFactory")
public class MyConfinguar {

    @Bean("dataSource")
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setMaxActive(DbProperties.maxActive);
        druidDataSource.setUsername(DbProperties.userName);
        druidDataSource.setPassword(DbProperties.password);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(DbProperties.maxPoolPreparedStatementPerConnectionSize);
        druidDataSource.setTestOnBorrow(DbProperties.testOnBorrow);
        druidDataSource.setTestOnReturn(DbProperties.testOnReturn);
        druidDataSource.setTestWhileIdle(DbProperties.testWhileIdle);
        druidDataSource.setInitialSize(DbProperties.initialSize);
        druidDataSource.setMinIdle(DbProperties.minIdle);
        druidDataSource.setMaxWait(DbProperties.maxWait);
        druidDataSource.setTimeBetweenConnectErrorMillis(DbProperties.timeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(DbProperties.minEvictableIdleTimeMillis);
        druidDataSource.setValidationQuery(DbProperties.validationQuery);
        druidDataSource.setPoolPreparedStatements(DbProperties.poolPreparedStatements);
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test_db?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true");
        return druidDataSource;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        Resource[] resource= resourceResolver.getResources("classpath*:mapper/*.xml");
        factoryBean.setMapperLocations(resource);
        return factoryBean.getObject();
    }

    @Bean("sqlSessionTemplate")
    public SqlSessionTemplate getSqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean("platformTransactionManager")
    public PlatformTransactionManager getPlatformTransactionManager(@Qualifier("dataSource") DataSource dataSource){
        return  new DataSourceTransactionManager(dataSource);
    }
}
