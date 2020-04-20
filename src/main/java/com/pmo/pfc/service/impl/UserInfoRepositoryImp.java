package com.pmo.pfc.service.impl;

import com.google.common.collect.Lists;
import com.pmo.pfc.api.dto.UserInfoDTO;
import com.pmo.pfc.common.BaseConstants;
import com.pmo.pfc.common.ResultCode;
import com.pmo.pfc.common.ServiceException;
import com.pmo.pfc.dao.entity.*;
import com.pmo.pfc.dao.mapper.ext.*;
import com.pmo.pfc.dao.query.OrganizationInfoQuery;
import com.pmo.pfc.dao.query.OrganizationRoleRelationQuery;
import com.pmo.pfc.dao.query.UserInfoQuery;
import com.pmo.pfc.service.UserInfoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class UserInfoRepositoryImp implements UserInfoRepository {

    @Resource
    private UserOrganizationRelationExtMapper userOrganizationRelationExtMapper;

    @Resource
    private OrganizationInfoExtMapper organizationInfoExtMapper;

    @Resource
    private UserInfoExtMapper userInfoExtMapper;

    @Resource
    private OrganizationRoleRelationExtMapper organizationRoleRelationExtMapper;

    @Resource
    private UserRoleRelationExtMapper userRoleRelationExtMapper;

    @Override
    public Integer createUser(UserInfoDTO userInfoDTO ) {
        //step1 添加用户信息
        UserInfoEntity record = new UserInfoEntity();
        BeanUtils.copyProperties(userInfoDTO,record);
        final Integer id = userInfoExtMapper.addUserInfo(record);

        //step2 添加用户组织
        List<OrganizationInfoEntity> organizationEntities = userInfoDTO.getOrganizationEntities();
        List<UserOrganizationRelationEntity> records = Lists.newArrayList();
        //添加默认组织
        OrganizationInfoQuery query = new OrganizationInfoQuery();
        if(CollectionUtils.isEmpty(organizationEntities)){
            query.orgCodeLike("default");
            organizationEntities =  organizationInfoExtMapper.selectByQuery(query);
            if(CollectionUtils.isEmpty(organizationEntities)){
                throw new ServiceException(ResultCode.DEFAULT_USER_ORG_NOT_EXIST);
            }
        }
        organizationEntities.forEach(item->{
            UserOrganizationRelationEntity relationDTO = new UserOrganizationRelationEntity();
            relationDTO.setOrgId(item.getId());
            relationDTO.setUserId(id);
            relationDTO.init(BaseConstants.INT_1);
            records.add(relationDTO);
        });
        userOrganizationRelationExtMapper.batchInsert(records);

        //step3 添加用户角色关系
        // 只添加所属组织下不存在的角色
        List<RoleInfoEntity> roleEntities = userInfoDTO.getRoleEntities();
        List<UserRoleRelationEntity> userRoles = Lists.newArrayList();
        if(!CollectionUtils.isEmpty(roleEntities)){
            OrganizationRoleRelationQuery orgRuleQuery = new OrganizationRoleRelationQuery();
            orgRuleQuery.orgCodeIn(organizationEntities.stream().map(OrganizationInfoEntity::getOrgCode).collect(Collectors.toList()));
            List<OrganizationRoleRelationEntity> orgRoleLists = organizationRoleRelationExtMapper.selectByQuery(orgRuleQuery);
            userRoles.addAll(roleEntities.stream().filter(item->
                    orgRoleLists.stream().noneMatch(x->x.getRoleId() == item.getId())
            ).map(item->{
                UserRoleRelationEntity userRoleRelationEntity = new UserRoleRelationEntity();
                userRoleRelationEntity.setRoleId(item.getId());
                userRoleRelationEntity.setUserId(id);
                userRoleRelationEntity.init(BaseConstants.INT_1);
                return userRoleRelationEntity;
            }).collect(Collectors.toList()));
            if(!CollectionUtils.isEmpty(userRoles)){
                // 插入用户角色关系（这个表没有存用户全部的角色，而是存入的用户所属的组织下不存在的角色）
                userRoleRelationExtMapper.batchInsert(userRoles);
            }
        }
        return id;
    }

    @Override
    public boolean checkUserIdExist(String userId, Integer id) {
        UserInfoQuery query = new UserInfoQuery();
        if(Objects.nonNull(id)){
            query.idNotEqual(id).and();
        }
        query.userIdEqual(userId);
        List<UserInfoEntity> userInfoEntities =  userInfoExtMapper.selectByQuery(query);
        return !CollectionUtils.isEmpty(userInfoEntities);
    }

}
