package com.pmo.pfc.common.util.sqlUtil;

public enum OperationEnum {

    AND("AND",100),
    OR("OR",101);

    private String operation;

    private int code;

    private OperationEnum(String operationStr,int code){
        this.operation = operationStr;
        this.code = code;
    }

    public String getOperation() {
        return operation;
    }

    public int getCode() {
        return code;
    }


}
