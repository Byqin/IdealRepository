package com.pmo.pfc.dao.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class RolePermissionsRelationDTO extends BaseEntity {

									
	/**
	* 描述 角色id
	*字段备注 role_id
	*/	
	private Integer roleId;
			
	/**
	* 描述 权限id
	*字段备注 permiss_id
	*/	
	private Integer permissId;
	
}

