package com.pmo.pfc.api.param;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class UserInfoParam extends BaseParam{

    @NotNull(message = "账号id不可为空")
    @Length(min = 4,max = 7,message = "账号id在4-7之间")
    private String userId;
    @NotNull(message = "中文名不可为空")
    @Length(min = 4,max = 20,message = "中文名在4-20之间")
    private String userNameCn;
    @Length(min = 4,max = 20,message = "英文名在4-20之间")
    private String userNameEn;
    private Integer sex;
    private Integer userAge;
    @Length(min = 3,max = 20,message = "邮箱在3-20之间")
    @Email(message = "邮箱格式不正确")
    private String email;
    @Length(min = 11,max = 11,message = "手机号长度为11")
    private String userPhone;
    private byte[] headPortrait;
    private Date birthday;

}
