package com.pmo.pfc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;



public class DbProperties {

    public static String userName = "test_user";
    public static String password = "123qwe";
    public static String dataBaseName = "test_db";
    public static int initialSize = 5;
    public static int minIdle=5;
    public static int maxActive=20;
    public static long maxWait=6000;
    public static long timeBetweenEvictionRunsMillis=3600000;
    public static long minEvictableIdleTimeMillis=1800000;
    public static String validationQuery="SELECT 1 FROM DUAL";
    public static boolean testWhileIdle = true;
    public static boolean testOnBorrow=true;
    public static boolean testOnReturn=true;
    public static boolean poolPreparedStatements=true;
    public static int maxPoolPreparedStatementPerConnectionSize=20;

}
