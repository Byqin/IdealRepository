package com.pmo.pfc.dao.mapper.ext;

import com.pmo.pfc.dao.entity.UserInfoEntity;
import org.springframework.stereotype.Repository;
import com.pmo.pfc.dao.mapper.UserInfoMapper;

@Repository
public interface UserInfoExtMapper extends UserInfoMapper{

    UserInfoEntity selectUserInfoByUserId(String userId);

}
