package com.pmo.pfc.dao.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class UserPermissionsDTO extends BaseEntity {

									
	/**
	* 描述 权限名称
	*字段备注 p_name
	*/	
	private String pName;
			
	/**
	* 描述 权限编码
	*字段备注 p_code
	*/	
	private String pCode;
			
	/**
	* 描述 父级编码
	*字段备注 parent_code
	*/	
	private String parentCode;
			
	/**
	* 描述 完整路径编码
	*字段备注 complete_code
	*/	
	private String completeCode;
			
	/**
	* 描述 请求后端接口
	*字段备注 request_url
	*/	
	private String requestUrl;
			
	/**
	* 描述 请求也没url
	*字段备注 requset_page
	*/	
	private String requsetPage;
			
	/**
	* 描述 扩展1
	*字段备注 extension_one
	*/	
	private String extensionOne;
			
	/**
	* 描述 扩展2
	*字段备注 extension_two
	*/	
	private String extensionTwo;
			
	/**
	* 描述 扩展3
	*字段备注 extension_three
	*/	
	private String extensionThree;
			
	/**
	* 描述 扩展4
	*字段备注 extension_four
	*/	
	private String extensionFour;
	
}

