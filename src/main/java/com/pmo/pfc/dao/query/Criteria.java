package com.pmo.pfc.dao.query;

import com.pmo.pfc.common.enu.OperatorEnum;
import org.apache.commons.lang3.StringUtils;

public class Criteria {

    private Object value;
    private String jdbcType;
    private String expression;
    private OperatorEnum operatorEnum;
    private String columnName;
    private boolean isColumn;

    public Criteria(String expression){
        this.expression = expression;
        this.isColumn = false;
    }

    public Criteria(Object value,String jdbcType,OperatorEnum operatorEnum,String columnName){
        this.value = value;
        this.expression = operatorEnum.getValue();
        this.jdbcType = jdbcType;
        this.operatorEnum  = operatorEnum;
        this.columnName = columnName;
        this.isColumn = StringUtils.isNotEmpty(columnName);
    }

    public static Criteria custom(Object value, String jdbcType, OperatorEnum operatorEnum,String columnName){
        return new Criteria(value,jdbcType,operatorEnum,columnName);
    }

    public static Criteria custom(String expression){
        return new Criteria(expression);
    }

    public boolean isIn(){
        return OperatorEnum.isIn(this.operatorEnum);
    }

    public boolean isLike(){
        return this.operatorEnum != null && OperatorEnum.LIKE.getCode() == this.operatorEnum.getCode();
    }

    public boolean isNotLike(){
        return this.operatorEnum != null &&  OperatorEnum.NOT_LIKE.getCode() == this.operatorEnum.getCode();
    }

    public boolean isNormal(){
        return !isIn() && !isLike() && !isNotLike();
    }

    public Object getValue() {
        return value;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public String getExpression() {
        return expression;
    }

    public String getColumnName() {
        return columnName;
    }

    public boolean isColumn() {
        return isColumn;
    }
}
