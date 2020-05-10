package com.pmo.pfc.common.util.sqlUtil;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MySqlBuildTest {

    private List<String> columnNames = Arrays.asList("age","sex","name");
    private List<String> columnNames1 = Arrays.asList("code","role","number","age");

    @Test
    public void testBuild(){
        MySqlBuild mySqlBuild = new MySqlBuild();
        mySqlBuild.build(initTable5());
        mySqlBuild.printInfo();
    }

    /**
     * 生成一个简单的查询结构
     * select t.age  AS age,t.sex  AS sex,t.name  AS name FROM user_info AS t
     */
    private TableEntity initTable(){
        return  initTable("user_inof","t",columnNames);
    }

    /**
     * 生成一个简单的查询结构
     * SELECT t.age  AS age,t.sex  AS sex,t.name  AS name
     * FROM   (  SELECT t.age  AS age,t.sex  AS sex,t.name  AS name FROM user_info AS t )  AS t0
     */
    private TableEntity initTable2(){
        TableEntity tableEntity = new TableEntity();

        List<ColumnEntity> columnEntities = Lists.newLinkedList();
        TableEntity joinTable = initTable();
        for (String item:columnNames){
            ColumnEntity columnEntity = new ColumnEntity();
            columnEntity.setTableEntity(joinTable);
            columnEntity.setAlias(item);
            columnEntity.setColumnName(item);
            columnEntities.add(columnEntity);
        }
        tableEntity.setShowColumnEntities(columnEntities);
        JoinEntity joinEntity = new JoinEntity();
        joinEntity.setJoinTable(joinTable);
        tableEntity.setJoinTables(Collections.singletonList(joinEntity));
        return tableEntity;
    }

    /**
     *  SELECT t.age  AS age,t.sex  AS sex,t.name  AS name,r.code  AS code,r.role  AS role,r.number  AS number,r.age  AS age
     *      FROM   (  SELECT t0.age  AS age,t0.sex  AS sex,t0.name  AS name FROM user_inof AS t0 )  AS t
     *      LEFT JOIN  (  SELECT r1.code  AS code,r1.role  AS role,r1.number  AS number,r1.age  AS age FROM role_table AS r1 )  AS r
     *      ON t.age=r.age
     * @return
     */
    private TableEntity initTable3(){
        TableEntity tableEntity = new TableEntity();
        List<ColumnEntity> columnEntities = Lists.newLinkedList();
        TableEntity joinTable1 = initTable("role_table","r",columnNames1);
        TableEntity joinTable = initTable();
        JoinEntity joinEntity = new JoinEntity();
        joinEntity.setJoinTable(joinTable);
        JoinEntity joinEntity1 = new JoinEntity();
        joinEntity1.setJoinTable(joinTable1);
        joinEntity1.setTableEntity(joinTable);
        joinEntity1.setJoinType(JoinTypeEnum.LEFT);
        joinEntity1.setJoinColumnName("age");
        joinEntity1.setOnColumnName("age");
        joinEntity1.setOrder(1);
        tableEntity.setJoinTables(Arrays.asList(joinEntity,joinEntity1));
        columnEntities.addAll(joinTable.getShowColumnEntities());
        columnEntities.addAll(joinTable1.getShowColumnEntities());
        tableEntity.setShowColumnEntities(columnEntities);
        return tableEntity;

    }

    /**
     * SELECT t.age  AS age,t.sex  AS sex,t.name  AS name,r.code  AS code,r.role  AS role,r.number  AS number,r.age  AS age
     *       FROM  user_inof AS t
     *       LEFT JOIN  (  SELECT r1.code  AS code,r1.role  AS role,r1.number  AS number,r1.age  AS age FROM role_table AS r1 )  AS r
     *       ON t.age=r.age
     * @return
     */
    private TableEntity initTable4(){
        TableEntity tableEntity = new TableEntity();
        List<ColumnEntity> columnEntities = Lists.newLinkedList();
        TableEntity joinTable1 = initTable("role_table","r",columnNames1);
        TableEntity joinTable = initTable();
        JoinEntity joinEntity = new JoinEntity();
        joinEntity.setJoinTable(joinTable);
        JoinEntity joinEntity1 = new JoinEntity();
        joinEntity1.setJoinTable(joinTable1);
        joinEntity1.setTableEntity(joinTable);
        joinEntity1.setJoinType(JoinTypeEnum.LEFT);
        joinEntity1.setJoinColumnName("age");
        joinEntity1.setOnColumnName("age");
        joinEntity1.setOrder(1);
        List<JoinEntity> lis = new ArrayList<>();
        lis.add(joinEntity);
        lis.add(joinEntity1);
        tableEntity.setJoinTables(lis);
        columnEntities.addAll(joinTable.getShowColumnEntities());
        columnEntities.addAll(joinTable1.getShowColumnEntities());
        tableEntity.setShowColumnEntities(columnEntities);
        //这一步是和initTable3的区别
        joinTable.setShowColumnEntities(null);
        return tableEntity;

    }

    /**
     * SELECT t.age  AS age,t.sex  AS sex,t.name  AS name,r.code  AS code,r.role  AS role,r.number  AS number,r.age  AS age,t.age  AS age,t.sex  AS sex,t.name  AS name
     * FROM  user_inof AS t
     * LEFT JOIN  (  SELECT r1.code  AS code,r1.role  AS role,r1.number  AS number,r1.age  AS age FROM role_table AS r1 )  AS r
     * ON t.age=r.age
     * RIGHT JOIN  (  SELECT t2.age  AS age,t2.sex  AS sex,t2.name  AS name FROM user_inof AS t2 )  AS t
     * ON r.age=t.age
     * @return
     */
    private TableEntity initTable5(){
        TableEntity tableEntity = initTable4();
        TableEntity joinTable = initTable();
        JoinEntity joinEntity = new JoinEntity();
        joinEntity.setJoinType(JoinTypeEnum.RIGHT);
        joinEntity.setJoinTable(joinTable);
        joinEntity.setJoinColumnName("age");
        joinEntity.setOnColumnName("age");
        joinEntity.setTableEntity(tableEntity.getJoinTables().get(1).getJoinTable());
        joinEntity.setOrder(2);
        tableEntity.getJoinTables().add(joinEntity);
        tableEntity.getShowColumnEntities().addAll(joinTable.getShowColumnEntities());
        return tableEntity;
    }

    private TableEntity initTable(String tableName,String alis ,List<String> columnNames){
        TableEntity tableEntity = new TableEntity();
        tableEntity.setAlias(alis);
        tableEntity.setTableName(tableName);
        List<ColumnEntity> columnEntities = Lists.newLinkedList();
        for (String item:columnNames){
            ColumnEntity columnEntity = new ColumnEntity();
            columnEntity.setTableEntity(tableEntity);
            columnEntity.setAlias(item);
            columnEntity.setColumnName(item);
            columnEntities.add(columnEntity);
        }
        tableEntity.setShowColumnEntities(columnEntities);
        return  tableEntity;
    }
}
