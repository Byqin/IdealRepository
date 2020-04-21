package com.pmo.pfc.dao.mapper.ext;

import com.pmo.pfc.dao.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.pmo.pfc.dao.mapper.UserInfoMapper;

@Repository
public interface UserInfoExtMapper extends UserInfoMapper{

    UserInfoEntity selectUserInfoByUserId(@Param("userId") String userId);

}
