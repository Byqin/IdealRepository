package com.pmo.pfc.config;

import com.pmo.pfc.web.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

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
}
