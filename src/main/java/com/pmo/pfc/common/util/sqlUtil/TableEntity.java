package com.pmo.pfc.common.util.sqlUtil;

import lombok.Data;

import java.util.List;

@Data
public class TableEntity {

    private String alias;

    private String tableName;

    private List<ColumnEntity> showColumnEntities;

    private List<ColumnEntity> whereColumnEntities;

    private List<JoinEntity> joinTables;

    private List<ColumnEntity> orderColumns;

    private List<ColumnEntity> hivingColumns;


}
