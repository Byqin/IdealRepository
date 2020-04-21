package com.pmo.pfc.service;

import com.pmo.pfc.dao.entity.PermissionsInfoEntity;
import com.pmo.pfc.dao.entity.RoleInfoEntity;

import java.util.List;

public interface RoleInfoRepository {

    /**
     * 根据组织代码查询其角色信息
     * @param orgCode
     * @return 组织下的角色
     */
    List<RoleInfoEntity> queryByOrgCode(String orgCode);

    /**
     * 根据组织代码集合查询其角色信息
     * @param orgCodes
     * @return 组织下的角色
     */
    List<RoleInfoEntity> queryByOrgCodes(List<String> orgCodes);

    /**
     * 根基用户主键id查询角色信息
     * @param userId
     * @return 用户的角色
     */
    List<RoleInfoEntity> queryByUserId(Integer userId);

    /**
     * 根据组织代码集合和用户主键id查询其用户所有角色信息
     * @param orgCodes
     * @return 用户所有角色
     */
    List<RoleInfoEntity> queryUserRoles(List<String> orgCodes,Integer userId);

    /**
     * 根据角色编码集合查询其权限
     * @param roleIds 角色编码集合
     * @return 所有角色的权限
     */
    List<PermissionsInfoEntity> queryAllPermissionsByRoleCodes(List<Integer> roleIds);
}
