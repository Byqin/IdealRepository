package com.pmo.pfc.common.util.sqlUtil;

import lombok.Data;

@Data
public class JoinEntity {

    private TableEntity tableEntity;
    private TableEntity joinTable;
    private JoinTypeEnum joinType;
    private String onColumnName ;
    private String joinColumnName;
    private int order = 0;

}
