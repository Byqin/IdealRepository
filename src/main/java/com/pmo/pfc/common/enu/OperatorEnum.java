package com.pmo.pfc.common.enu;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public enum OperatorEnum {

    EQ(100,"="),
    NEQ(101,"!="),
    LG(102,">"),
    LGE(103,">="),
    LT(104,"<"),
    LTE(105,"<="),
    LIKE(106," "){
        @Override
        public String getExpression(String columnName, Object value) {
            return OperatorEnum.getListExpression(this,columnName,value);
        }
    },
    NOT_LIKE(107,"LOCATE"){
        @Override
        public String getExpression(String columnName, Object value) {
            return OperatorEnum.getListExpression(this,columnName,value);
        }
    },
    IN(108,"in"){
        @Override
        public String getExpression(String columnName, Object value) {
            return OperatorEnum.getListExpression(this,columnName,value);
        }
    },
    NOT_IN(109,"not in"){
        @Override
        public String getExpression(String columnName, Object value) {
            return OperatorEnum.getListExpression(this,columnName,value);
        }
    },
    IS_EMPTY(110," is null"){
        @Override
        public String getExpression(String columnName, Object value) {
            return  OperatorEnum.getEmptyTypeExpression(this,columnName);
        }
    },
    IS_NOT_EMPTY(111," not is null"){
        @Override
        public String getExpression(String columnName, Object value) {
            return OperatorEnum.getEmptyTypeExpression(this,columnName);
        }
    },
    AND(200,"and"),
    OR(2001,"or");

    private int code;
    private String value;

    private OperatorEnum(int code,String value){
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    private static String getLikeExpression(OperatorEnum operatorEnum,String columnName,Object value){
        return MessageFormat.format("{0}('{1}',{2}) > 0",operatorEnum.getValue(),value,columnName);
    }

    private static String getListExpression(OperatorEnum operatorEnum,String columnName,Object value){
        if(value instanceof Collection){
            Collection<?> list = (Collection)value;
            return MessageFormat.format(" {0} {1} {2}",columnName,operatorEnum.getValue(),
                            list.stream().map(String::valueOf).collect(Collectors.joining(",")));
        }
        return "";
    }

    private static String getEmptyTypeExpression(OperatorEnum operatorEnum,String columnName){
        return MessageFormat.format(" {0} {1} ",columnName,operatorEnum.getValue());
    }

    public String getExpression(String columnName,Object value){
        if(Objects.isNull(value)){
            value = "'null'";
        }
        return MessageFormat.format(" {0} {1} {2}",columnName,this.value,value);
    }

    public static boolean isIn(OperatorEnum operatorEnum){
        return operatorEnum != null && (operatorEnum.getCode() == IN.getCode() || operatorEnum.getCode() == NOT_IN.getCode());
    }

    public static boolean isLike(OperatorEnum operatorEnum){
        return operatorEnum != null && (operatorEnum.getCode() == LIKE.getCode() || operatorEnum.getCode() == NOT_LIKE.getCode());
    }
}
