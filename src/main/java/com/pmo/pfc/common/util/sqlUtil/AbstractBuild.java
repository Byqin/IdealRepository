package com.pmo.pfc.common.util.sqlUtil;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import java.util.List;

@Slf4j
public abstract class AbstractBuild implements  SqlBuild<TableEntity>{

    /**
     * one:
     *   select xx.a , xx.b from xxx as xx where xx.id = 11
     * two:
     *   select xx.a AS A , xx.b as B ,yy.v as V from xxx as xx left join yyy as yy where xx.id = 11
     * three:
     *   select xx.a AS A , xx.b as B ,yy.v as V ,cc.g AS G
     *   from
     *      xxx as xx
     *   left join
     *      yyy as yy
     *   left join
     *      ( select qq.a AS a from qqq AS qq where qq.a = 1) as cc
     *  where xx.id = 11
     *
     * four：
     *   select cc.a AS A  from ( select qq.a AS a from qqq AS qq where qq.a = 1) as cc
     *
     */

    private StringBuilder sqlBuild;

    private boolean isInit = true;

    private TableEntity tableEntity;


    @Override
    public String toSql() {
        return sqlBuild == null ? null : sqlBuild.toString();
    }

    @Override
    public String select(TableEntity tableEntity) {

        List<ColumnEntity> showColumnEntities = tableEntity.getShowColumnEntities();
        StringBuilder selectBuild = new StringBuilder(" SELECT ");
        if(CollectionUtils.isEmpty(showColumnEntities)){
            throw  new IllegalStateException("  show Column not empty with table " + tableEntity.getAlias());
        }
        for (ColumnEntity entity : showColumnEntities){
            selectBuild.append(entity.getTableEntity().getAlias())
                        .append(".")
                        .append(entity.getColumnName())
                        .append("  AS ")
                        .append(entity.getAlias())
                        .append(",");
        }
        selectBuild.replace(selectBuild.length()-1,selectBuild.length(),"");
        sqlBuild.append(selectBuild.toString());
        return selectBuild.toString();
    }

    @Override
    public String from(TableEntity tableEntity) {

        sqlBuild.append(" FROM ");
        List<JoinEntity> joinEntities = tableEntity.getJoinTables();
        if(!CollectionUtils.isEmpty(joinEntities)){
            // 有连接的表
            for (JoinEntity joinType : joinEntities){
                boolean flag = joinType.getJoinType() != null;
                if(flag ){
                    appendBlankSpace(sqlBuild).append(joinType.getJoinType().getValue());
                }
                TableEntity joinTable = joinType.getJoinTable();
                final String metaTableAlias =  joinTable.getAlias();
                appendBlankSpace(sqlBuild);
                if(CollectionUtils.isEmpty(joinTable.getShowColumnEntities())){
                    //没有展示字段，直接拼接
                    sqlBuild.append(joinTable.getTableName())
                                               .append(" AS ")
                                               .append(metaTableAlias);
                }else{
                    joinTable.setAlias(joinTable.getAlias()+joinType.getOrder());
                    sqlBuild.append(" ( ");
                    build(joinTable);
                    sqlBuild.append(" ) ")
                            .append(" AS ")
                            .append(metaTableAlias);
                }
                if(flag ){
                    appendBlankSpace(sqlBuild).append("ON ")
                                              .append(joinType.getTableEntity().getAlias())
                                              .append(".")
                                              .append(joinType.getJoinColumnName())
                                              .append("=")
                                              .append(metaTableAlias)
                                              .append(".")
                                              .append(joinType.getOnColumnName());
                }
                joinTable.setAlias(metaTableAlias);
            }
        }else{
            // 没有连接表时，直接取当前表
            sqlBuild.append(tableEntity.getTableName()).append(" AS ").append(tableEntity.getAlias());
        }
        /*fromBuilders.add(fromBuild);
        sqlBuild.append(fromBuild.toString());*/
        return null;
    }

    public void build(TableEntity tableEntity){
        try {
            init(tableEntity);

            select(tableEntity);

            from(tableEntity);

            where(tableEntity);

            orderBy(tableEntity);

            hiving(tableEntity);
        }catch (Exception e){
            throw  new IllegalStateException("  build sql error ！ ",e);
        }
    }

    private void init(TableEntity tableEntity){
        if(isInit){
            isInit = false;
            sqlBuild = new StringBuilder();
            this.tableEntity = tableEntity;
        }
    }

    public void refresh(){
        check();
        build(this.tableEntity);
    }

    private void check(){
        if(this.tableEntity == null){
            throw  new IllegalStateException("  build sql error ！ tableEntity not null");
        }
    }

    private StringBuilder appendBlankSpace(StringBuilder sb ){
        sb.append(" ");
        return sb;
    }

    public void printInfo(){
        log.info(toSql());
    }
}
