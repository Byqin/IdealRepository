package com.pmo.pfc.dao.entity;

import com.pmo.pfc.common.BaseConstants;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class BaseEntity implements Serializable {

    private Integer id;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private Integer isDelete;

    private Integer ver;

    public void init(int isDelete){
        Date now = new Date();
        this.createBy = "system";
        this.createDate = now;
        this.updateBy = "system";
        this.updateDate = now;
        this.isDelete = isDelete;
        this.ver = BaseConstants.INT_0;
    }

}
