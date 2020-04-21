package com.pmo.pfc.service;

import com.pmo.pfc.api.dto.UserInfoDTO;

public interface UserInfoRepository {

    /**
     * 创建用户
     * 1.创建用户信息
     * 2.关联组织（没有组织时，添加默认组织）
     * 3.关联角色信息（添加与组织的角色的并集）
     *
     * @param userInfoDTO 用户信息dto
     * @return
     */
    Integer createUser(UserInfoDTO userInfoDTO );

    /**
     * 检查用户id是否存在
     * 用户主键id不为null时，查询主键id不等于id，否则该值不会作为条件
     *
     * @param userId 用户id
     * @param id 用户主键id
     * @return
     */
    boolean checkUserIdExist(String userId,Integer id);

    /**
     * 根据用户id获取用户信息
     * @param userId  用户id
     * @return 返回用户信息
     */
    UserInfoDTO getUserInfoByUserId(String userId);

}
