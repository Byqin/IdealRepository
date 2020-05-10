package com.pmo.pfc.common.util.sqlUtil;

public enum JoinTypeEnum {

    RIGHT("RIGHT JOIN",100),
    LEFT("LEFT JOIN",101),
    INNER("INNER JOIN",102);

    private String value;
    private int code;

    private JoinTypeEnum(String value,int code){
        this.value = value;
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public int getCode() {
        return code;
    }
}
