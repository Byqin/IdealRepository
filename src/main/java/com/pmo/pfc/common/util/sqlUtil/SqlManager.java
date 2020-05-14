package com.pmo.pfc.common.util.sqlUtil;

public class SqlManager<T> {

    private SqlBuild<T> builder;

    public SqlManager(SqlBuild<T> builder) {
        this.builder = builder;
    }

    public String getSql(T entity){
        this.builder.select(entity);
        this.builder.from(entity);
        this.builder.where(entity);
        this.builder.orderBy(entity);
        this.builder.hiving(entity);
        this.builder.limit(0,10);
        return this.builder.toSql();
    }
}
