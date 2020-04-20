package com.pmo.pfc.dao.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class RolePermissionsRelationEntity extends BaseEntity {

									
	/**
	* 描述 角色主键id
	*字段备注 role_id
	*/	
	private Integer roleId;
			
	/**
	* 描述 权限id
	*字段备注 p_code
	*/	
	private String pCode;
	
}

