package com.pmo.pfc.dao.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class UserOrganizationRelationDTO extends BaseEntity {

									
	/**
	* 描述 用户id
	*字段备注 user_id
	*/	
	private Integer userId;
			
	/**
	* 描述 组织id
	*字段备注 org_id
	*/	
	private Integer orgId;
	
}

