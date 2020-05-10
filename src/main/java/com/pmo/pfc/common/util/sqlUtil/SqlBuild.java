package com.pmo.pfc.common.util.sqlUtil;

public interface SqlBuild<T> {

    String select(T sql);

    String toSql();

    String limit(int start,int end);

    String orderBy(T orderSql);

    String hiving(T hivingSql);

    String from(T sql);

    String where(T sql);



}
