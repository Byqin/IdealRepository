package com.pmo.pfc.web.controller;

import com.pmo.pfc.api.param.UserInfoParam;
import com.pmo.pfc.biz.UserInfoService;
import groovy.util.logging.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    @GetMapping(path = "/getInfo" ,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String getUserInfo(String userId){
        return userInfoService.getUserInfo(userId);
    }

    @PostMapping(path = "/saveInfo" ,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String saveInfo(@RequestBody @Valid UserInfoParam param){
        return userInfoService.saveInfo(param);
    }

    @PostMapping(path = "/queryList" ,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String queryList(@RequestBody String userId){
        return userInfoService.queryInfo(userId);
    }
}
