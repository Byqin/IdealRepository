package com.pmo.pfc.service.impl;

import com.pmo.pfc.dao.entity.*;
import com.pmo.pfc.dao.mapper.ext.*;
import com.pmo.pfc.dao.query.*;
import com.pmo.pfc.service.RoleInfoRepository;
import org.apache.commons.compress.utils.Lists;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RoleInfoRepositoryImp implements RoleInfoRepository {

    @Resource
    private OrganizationRoleRelationExtMapper organizationRoleRelationExtMapper;

    @Resource
    private UserRoleRelationExtMapper userRoleRelationExtMapper;

    @Resource
    private RoleInfoExtMapper roleInfoExtMapper;

    @Resource
    private PermissionsInfoExtMapper permissionsInfoExtMapper;

    @Resource
    private RolePermissionsRelationExtMapper rolePermissionsRelationExtMapper;

    @Override
    public List<RoleInfoEntity> queryByOrgCode(String orgCode) {
        return queryByOrgCodes(Collections.singletonList(orgCode));
    }

    @Override
    public List<RoleInfoEntity> queryByOrgCodes(List<String> orgCodes) {
        if(CollectionUtils.isEmpty(orgCodes)){
            return Lists.newArrayList();
        }
        OrganizationRoleRelationQuery query = new OrganizationRoleRelationQuery();
        query.orgCodeIn(orgCodes);
        List<OrganizationRoleRelationEntity> orgRoles = organizationRoleRelationExtMapper.selectByQuery(query);
        if(CollectionUtils.isEmpty(orgRoles)){
            return Lists.newArrayList();
        }
        RoleInfoQuery roleInfoQuery = roleIdInQuery(orgRoles.stream()
                                                            .map(OrganizationRoleRelationEntity::getRoleId)
                                                            .collect(Collectors.toList())
                                                  );
        return roleInfoExtMapper.selectByQuery(roleInfoQuery);
    }

    @Override
    public List<RoleInfoEntity> queryByUserId(Integer userId) {
        UserRoleRelationQuery query = new UserRoleRelationQuery();
        query.userIdEqual(userId);
        List<UserRoleRelationEntity> orgRoles = userRoleRelationExtMapper.selectByQuery(query);
        if(CollectionUtils.isEmpty(orgRoles)){
            return Lists.newArrayList();
        }
        RoleInfoQuery roleInfoQuery = roleIdInQuery(orgRoles.stream()
                .map(UserRoleRelationEntity::getRoleId)
                .collect(Collectors.toList())
        );
        return roleInfoExtMapper.selectByQuery(roleInfoQuery);
    }

    @Override
    public List<RoleInfoEntity> queryUserRoles(List<String> orgCodes, Integer userId) {
        List<RoleInfoEntity> results = Lists.newArrayList();
        List<RoleInfoEntity> orgRoleInfos = queryByOrgCodes(orgCodes);
        List<RoleInfoEntity> userInfos = queryByUserId(userId);
        results.addAll(orgRoleInfos);
        results.addAll(userInfos);
        return results;
    }

    @Override
    public List<PermissionsInfoEntity> queryAllPermissionsByRoleCodes(List<Integer> roleIds) {
        if(CollectionUtils.isEmpty(roleIds)){
            return Lists.newArrayList();
        }
        RolePermissionsRelationQuery query = new RolePermissionsRelationQuery();
        query.roleIdIn(roleIds);
        List<RolePermissionsRelationEntity> rolePermissions = rolePermissionsRelationExtMapper.selectByQuery(query);
        if(CollectionUtils.isEmpty(rolePermissions)){
            return Lists.newArrayList();
        }
        PermissionsInfoQuery permissionsInfoQuery = new PermissionsInfoQuery();
        permissionsInfoQuery.parentCodeIn(rolePermissions.stream()
                                                         .map(RolePermissionsRelationEntity::getPCode)
                                                         .distinct()
                                                         .collect(Collectors.toList())
                                          );
        return permissionsInfoExtMapper.selectByQuery(permissionsInfoQuery);
    }

    private RoleInfoQuery roleIdInQuery(List<Integer> roleIds){
        Assert.notEmpty(roleIds,"角色id不可为空");
        RoleInfoQuery roleInfoQuery = new RoleInfoQuery();
        roleInfoQuery.idIn(roleIds);
        return roleInfoQuery;
    }
}
