package com.pmo.pfc.service;

import com.pmo.pfc.dao.entity.UserInfoDTO;

public interface UserInfoRepository {

    Integer createUser(UserInfoDTO record );

    boolean checkUserIdExist(String userId,Integer id);

}
