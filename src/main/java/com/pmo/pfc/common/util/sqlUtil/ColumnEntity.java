package com.pmo.pfc.common.util.sqlUtil;

import lombok.Data;

@Data
public class ColumnEntity {

    private String alias;

    private String columnName;

    private TableEntity tableEntity;

}
