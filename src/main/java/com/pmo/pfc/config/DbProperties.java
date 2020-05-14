package com.pmo.pfc.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
@ConfigurationProperties(prefix = "db")
@Data
public class DbProperties {

    private  String userName ;
    private  String password ;
    private  int initialSize ;
    private  int minIdle;
    private  int maxActive;
    private  long maxWait;
    private  long timeBetweenEvictionRunsMillis;
    private  long minEvictableIdleTimeMillis;
    private  String validationQuery;
    private  boolean testWhileIdle ;
    private  boolean testOnBorrow;
    private  boolean testOnReturn;
    private  boolean poolPreparedStatements;
    private  int maxPoolPreparedStatementPerConnectionSize;

}
