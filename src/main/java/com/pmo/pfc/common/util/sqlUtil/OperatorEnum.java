package com.pmo.pfc.common.util.sqlUtil;

public enum OperatorEnum {

    /**
     * 由于通配符的缘故，导致我们查询特殊字符"%"、"_"、"["的语句无法正常实现，而把特殊字符用"[ ]"括起便可正常查询。据此我们写出以下函数：
     * function sqlencode(str)
     * str=replace(str,"[","[[]") '此句一定要在最前
     * str=replace(str,"_","[_]")
     * str=replace(str,"%","[%]")
     * sqlencode=str
     * end function
     * [ ]：表示括号内所列字符中的一个（类似正则表达式）。指定一个字符、字符串或范围，要求所匹配对象为它们中的任一个。
     * [^ ] ：表示不在括号所列之内的单个字符。其取值和 [] 相同，但它要求所匹配对象为指定字符以外的任一个字符。
     */

    GT(">",100),
    GTE(">=",101),
    LT("<",102),
    LTE("<=",103),
    EQ("=",104),
    NEQ("!=",105),
    LIKE("like",106),
    NOT_LIKE("not like",107),
    IN("in",108),
    NOT_IN("not in",109);

    private String operator;

    private int code;

    private OperatorEnum(String operator,int code){
        this.operator = operator;
        this.code = code;
    }

    public boolean isInEnum(){
        return this.code == IN.code || this.code == NOT_IN.code;
    }

    public boolean notIsInEnum(){
        return !isInEnum();
    }
}
