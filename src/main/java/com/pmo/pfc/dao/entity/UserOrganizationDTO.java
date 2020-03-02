package com.pmo.pfc.dao.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class UserOrganizationDTO extends BaseEntity {

									
	/**
	* 描述 组织名称
	*字段备注 org_name
	*/	
	private String orgName;
			
	/**
	* 描述 组织编码
	*字段备注 org_code
	*/	
	private String orgCode;
	
}

