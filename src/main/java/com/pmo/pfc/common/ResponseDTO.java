package com.pmo.pfc.common;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class ResponseDTO<T> {

    private String code;
    private String message;
    private T data;

    private ResponseDTO(){
        this.code = "0000";
        this.message = "成功";
    }

    public ResponseDTO(T data){
        this.data = data;
        this.code = "0000";
        this.message = "成功";
    }

    public String failToString(){
        return  failToString("0001","请求失败");
    }

    public String  failToString(ResultCode code){
        return failToString(code.getCode(),code.getMessage());
    }

    public String failToString(String code,String message){
        this.code = code;
        this.message = message;
        return this.toString();
    }



    public static ResponseDTO newInstance(){
        return new ResponseDTO();
    }

    public  static ResponseDTO newInstance(Object data){
        return new ResponseDTO<>(data);
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
