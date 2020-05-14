package com.pmo.pfc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.compress.utils.Lists;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
@MapperScan(basePackages = {"com.pmo.pfc.dao.mapper"},sqlSessionFactoryRef = "sqlSessionFactory")
public class MyConfinguar {

    private static Logger log  = LoggerFactory.getLogger(MyConfinguar.class);

    @javax.annotation.Resource
    private DbProperties dbProperties;

    @Bean("dataSource")
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setMaxActive(dbProperties.getMaxActive());
        druidDataSource.setUsername(dbProperties.getUserName());
        druidDataSource.setPassword(dbProperties.getPassword());
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(dbProperties.getMaxPoolPreparedStatementPerConnectionSize());
        druidDataSource.setTestOnBorrow(dbProperties.isTestOnBorrow());
        druidDataSource.setTestOnReturn(dbProperties.isTestOnReturn());
        druidDataSource.setTestWhileIdle(dbProperties.isTestWhileIdle());
        druidDataSource.setInitialSize(dbProperties.getInitialSize());
        druidDataSource.setMinIdle(dbProperties.getMinIdle());
        druidDataSource.setMaxWait(dbProperties.getMaxWait());
        druidDataSource.setTimeBetweenConnectErrorMillis(dbProperties.getTimeBetweenEvictionRunsMillis());
        druidDataSource.setMinEvictableIdleTimeMillis(dbProperties.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(dbProperties.getValidationQuery());
        druidDataSource.setPoolPreparedStatements(dbProperties.isPoolPreparedStatements());
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test_db?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true");
        return druidDataSource;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        List<Resource> resources = Lists.newArrayList();
        Resource[] resource = resourceResolver.getResources("classpath*:mapper/*.xml");
        Resource[] resourceExt = resourceResolver.getResources("classpath*:mapper/ext/*.xml");
        resources.addAll(Arrays.asList(resource));
        resources.addAll(Arrays.asList(resourceExt));
        factoryBean.setMapperLocations(resources.toArray(new Resource[0]));
        return factoryBean.getObject();
    }

    @Bean("sqlSessionTemplate")
    public SqlSessionTemplate getSqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean("platformTransactionManager")
    @Primary
    public PlatformTransactionManager getPlatformTransactionManager(@Qualifier("dataSource") DataSource dataSource){
        return  new DataSourceTransactionManager(dataSource);
    }

    @Bean("threadPoolExecutor")
    @Primary
    public ThreadPoolExecutor getExecutor() {
        ThreadFactory factory = new ThreadFactoryBuilder()
                .setNameFormat(ThreadPoolProperties.NAME_FORMAT)
                .setUncaughtExceptionHandler((Thread t,Throwable e)-> log.error("{}线程出现错误",t.getName(),e))
                .build();
        return new ThreadPoolExecutor(ThreadPoolProperties.CORE_POOL_SIZE,
                ThreadPoolProperties.MAX_POOL_SIZE,
                ThreadPoolProperties.KEEP_ALIVE_MS,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(),
                factory,
                new ThreadPoolExecutor.AbortPolicy());
    }

    /**
     * Guava
     * @return
     */
    public ListeningExecutorService getListenerExecutor() {
        ThreadPoolExecutor executor = getExecutor();
        return MoreExecutors.listeningDecorator(executor);
    }


    private static class ThreadPoolProperties{

        public static final String NAME_FORMAT =  "my-project";

        public static final Integer MAX_POOL_SIZE =  10;

        public static final Integer KEEP_ALIVE_MS  =  1000;

        public static final Integer CORE_POOL_SIZE  =  10;

    }
}
