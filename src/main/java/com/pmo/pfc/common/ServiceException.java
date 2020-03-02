package com.pmo.pfc.common;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
public class ServiceException extends RuntimeException {

    private String code;
    private String msg;

    public ServiceException(){
        super();
        this.code = ResultCode.ERROR.getCode();
        this.msg = ResultCode.ERROR.getMessage();
    }

    public ServiceException(String message){
        super(message);
        this.msg = message;
        this.code = ResultCode.ERROR.getCode();
    }

    public ServiceException(ResultCode code){
        super(code.getMessage());
        this.msg = code.getMessage();
        this.code = code.getCode();
    }

    public ServiceException(String code, String message){
        super(message);
        this.msg = message;
        this.code = code;
    }

    public ServiceException(String code, String message,Throwable cause){
        super(message,cause);
        this.msg = message;
        this.code = code;
    }

    public ServiceException(String message, Throwable cause){
        super(message,cause);
        this.msg = message;
        this.code = ResultCode.ERROR.getCode();
    }

    public ServiceException(ResultCode code, Throwable cause){
        super(code.getMessage(),cause);
        this.msg = code.getMessage();
        this.code = code.getCode();
    }

    public String getDefaultMessage(){
        if(StringUtils.isEmpty(this.msg)){
            return super.getMessage();
        }
        return this.msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setResultCode(ResultCode code){
        this.code = code.getCode();
        this.msg = code.getMessage();
    }
}
