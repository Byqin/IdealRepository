package com.pmo.pfc.web.controller;

import com.pmo.pfc.common.ResponseDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
/**
 * 参考BasicErrorController
 */
public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController  {


    @RequestMapping(path = "/error")
    public String error(HttpServletRequest request){
        return ResponseDTO.newInstance()
                          .failToString(String.valueOf(request.getAttribute("javax.servlet.error.status_code")),
                            (String)request.getAttribute("javax.servlet.error.message"));
    }


    @Override
    public String getErrorPath() {
        return "/error";
    }
}
