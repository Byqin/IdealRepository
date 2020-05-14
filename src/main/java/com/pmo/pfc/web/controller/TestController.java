package com.pmo.pfc.web.controller;

import com.pmo.pfc.common.annotation.LogAnnotation;
import com.pmo.pfc.etl.Demo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @Resource
    private Demo demo;

    @LogAnnotation
    @RequestMapping(path = "/test/ss",method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Map<String,String> testObject(){
        Map<String,String > data = new HashMap<>();
        data.put("xx","xxx");
        Thread thread = new Thread(()->{
            try{
                demo.testRUN();
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        thread.start();
        return data;
    }

}
