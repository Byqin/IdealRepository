package com.pmo.pfc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserPageController {

    @RequestMapping("login")
    public String demo(){
        return "login/signin";
    }

    @RequestMapping("{page}")
    public String dynamic(@PathVariable  String page){
        return page;
    }



}
