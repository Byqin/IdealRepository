package com.pmo.pfc.web.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

// ControllerAdvice 和 Aspect 是两种切面，Aspect的作用域更大
@Aspect
@Component
@Slf4j
public class LogControllerAdvice {

    private ThreadLocal<Long> currentTheadLocal = new ThreadLocal<>();

    @Pointcut("execution(public * com.pmo.pfc.web.controller..*.*(..)) && @annotation(com.pmo.pfc.common.annotation.LogAnnotation)")
    private void pointCut(){

    }

    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint){
        // 如果调around ，before同时有，只会调用around，否则调用before，就不会调用around
        log.info("======before：日志开始了！！！！！！！=======");
    }

    @After(value = "pointCut()")
    public void after(JoinPoint joinPoint){
        log.info("======after：日志开始了！！！！！！！=======");
    }

    @AfterReturning(value = "pointCut()")
    public void afterReturn(JoinPoint joinPoint){
        log.info("======afterReturn：日志开始了！！！！！！！=======");
    }

    @AfterThrowing(value = "pointCut()")
    public void afterThrowing(JoinPoint joinPoint){
        log.info("======AfterThrowing：日志开始了！！！！！！！=======");
    }

    //@Around(value = "pointCut()")
    public void around(JoinPoint joinPoint){
        log.info("======around：日志开始了！！！！！！！=======");
    }
}
