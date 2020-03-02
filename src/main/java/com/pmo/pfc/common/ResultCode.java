package com.pmo.pfc.common;

public enum ResultCode {

    SUCCESS("0000","成功"),
    FAIL("0001","失败"),
    ERROR("0002","系统异常"),
    PARAM_ERROR("0003","缺少参数"),
    SQL_ERROR("0004","sql异常"),

    USER_NOT_EXIST("5000","用户不存在"),
    DEFAULT_USER_ORG_NOT_EXIST("5001","默认的用户组织不存在"),
    USER_ID_EXIST("5002","用户账号已存在");

    private String code;
    private String message;

    private ResultCode(String code,String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
