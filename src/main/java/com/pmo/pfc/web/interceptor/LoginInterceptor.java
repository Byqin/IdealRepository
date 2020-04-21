package com.pmo.pfc.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Value("exclude-url")
    private String excludeUrl;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        log.info("=========  preHandle start =======");
        // true 则可以执行下个Interceptor 否则就表示请求已结束
        // 排除的url不进行账户验证
        if(StringUtils.isNotEmpty(excludeUrl)){
            request.getRequestURI();
            if(excludeUrl.contains(request.getRequestURI())){
                return true;
            }
        }
        //TODO 验证用户是否登录，且账号是否正常，每次都刷新session过期时间
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        // 业务流程走完后的处理
        log.info("=========  postHandle start =======");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        // 流程中出现异常的处理
        log.info("=========  afterCompletion start =======");
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request,
                                               HttpServletResponse response,
                                               Object handler) throws Exception {
        // 最后的处理 即finally
        log.info("=========  afterConcurrentHandlingStarted start =======");
    }
}
