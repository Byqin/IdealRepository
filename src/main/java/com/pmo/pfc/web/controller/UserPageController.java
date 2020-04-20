package com.pmo.pfc.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class UserPageController {

    private static final Map<String,String > pathMap = new HashMap<>();

    static {
        pathMap.put("mainPage","background/mainPage");
    }

    @RequestMapping("login")
    public String demo(){
        return "login/signin";
    }

    @RequestMapping("{page}")
    public String dynamic(@PathVariable  String page){
        log.info("请求路径:"+page);
        return pathMap.get(page);
    }

}
