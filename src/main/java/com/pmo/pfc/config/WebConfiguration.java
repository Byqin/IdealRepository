package com.pmo.pfc.config;

import com.pmo.pfc.web.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * 所有mvc config的配置都在这个类实现，实现对应的方法即可
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Resource
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor  = registry.addInterceptor(loginInterceptor);
        //排除的路径
        /*addInterceptor.excludePathPatterns("/error");
        addInterceptor.excludePathPatterns("/login**");*/
        addInterceptor.addPathPatterns("/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:80")
                .allowedMethods("PUT", "DELETE","GET","POST")
                .allowedHeaders("origins-host", "app-name", "header3")
                .exposedHeaders("header1", "header2")
                .allowCredentials(true).maxAge(3600);
    }
}
