package com.pmo.pfc.biz;

import com.pmo.pfc.api.param.UserInfoParam;

public interface UserInfoService {

    /**
     * 根据用户id查询用户信息
     * @param userId 用户id
     * @return 返回用户信息json
     */
    String getUserInfo(String userId);

    String saveInfo(UserInfoParam param);

    String queryInfo(String userId);

}
