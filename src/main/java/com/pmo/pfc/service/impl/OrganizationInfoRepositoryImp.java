package com.pmo.pfc.service.impl;

import com.pmo.pfc.dao.entity.OrganizationInfoEntity;
import com.pmo.pfc.dao.entity.UserOrganizationRelationEntity;
import com.pmo.pfc.dao.mapper.ext.OrganizationInfoExtMapper;
import com.pmo.pfc.dao.mapper.ext.UserOrganizationRelationExtMapper;
import com.pmo.pfc.dao.query.OrganizationInfoQuery;
import com.pmo.pfc.dao.query.UserOrganizationRelationQuery;
import com.pmo.pfc.service.OrganizationInfoRepository;
import org.apache.commons.compress.utils.Lists;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrganizationInfoRepositoryImp implements OrganizationInfoRepository {

    @Resource
    private UserOrganizationRelationExtMapper userOrganizationRelationExtMapper;

    @Resource
    private OrganizationInfoExtMapper organizationInfoExtMapper;

    @Override
    public List<OrganizationInfoEntity> queryByUserId(Integer userId) {
        UserOrganizationRelationQuery query = new UserOrganizationRelationQuery();
        query.userIdEqual(userId);
        List<UserOrganizationRelationEntity> userOrgLists = userOrganizationRelationExtMapper.selectByQuery(query);
        if(CollectionUtils.isEmpty(userOrgLists)){
            return Lists.newArrayList();
        }
        OrganizationInfoQuery orgQuery = new OrganizationInfoQuery();
        orgQuery.orgCodeIn(userOrgLists.stream().map(UserOrganizationRelationEntity::getOrgCode).collect(Collectors.toList()));
        return organizationInfoExtMapper.selectByQuery(orgQuery);
    }
}
