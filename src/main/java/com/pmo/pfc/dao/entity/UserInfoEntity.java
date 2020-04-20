package com.pmo.pfc.dao.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class UserInfoEntity extends BaseEntity {

									
	/**
	* 描述 用户账号
	*字段备注 user_id
	*/	
	private String userId;
			
	/**
	* 描述 用户中文名称
	*字段备注 user_name_cn
	*/	
	private String userNameCn;
			
	/**
	* 描述 用户英文名称
	*字段备注 user_name_en
	*/	
	private String userNameEn;
			
	/**
	* 描述 性别：0 男 1 女
	*字段备注 sex
	*/	
	private Integer sex;
			
	/**
	* 描述 年龄
	*字段备注 user_age
	*/	
	private Integer userAge;
			
	/**
	* 描述 邮箱
	*字段备注 email
	*/	
	private String email;
			
	/**
	* 描述 电话
	*字段备注 user_phone
	*/	
	private String userPhone;
			
	/**
	* 描述 头像
	*字段备注 head_portrait
	*/	
	private byte[] headPortrait;
			
	/**
	* 描述 生日
	*字段备注 birthday
	*/	
	private Date birthday;
	
}

