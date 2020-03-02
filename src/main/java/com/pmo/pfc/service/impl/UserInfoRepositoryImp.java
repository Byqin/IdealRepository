package com.pmo.pfc.service.impl;

import com.google.common.collect.Lists;
import com.pmo.pfc.common.BaseConstants;
import com.pmo.pfc.common.ResultCode;
import com.pmo.pfc.common.ServiceException;
import com.pmo.pfc.dao.entity.UserInfoDTO;
import com.pmo.pfc.dao.entity.UserOrganizationDTO;
import com.pmo.pfc.dao.entity.UserOrganizationRelationDTO;
import com.pmo.pfc.dao.mapper.ext.UserInfoExtMapper;
import com.pmo.pfc.dao.mapper.ext.UserOrganizationExtMapper;
import com.pmo.pfc.dao.mapper.ext.UserOrganizationRelationExtMapper;
import com.pmo.pfc.dao.query.UserInfoQuery;
import com.pmo.pfc.dao.query.UserOrganizationQuery;
import com.pmo.pfc.service.UserInfoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Repository
public class UserInfoRepositoryImp implements UserInfoRepository {

    @Resource
    private UserOrganizationRelationExtMapper userOrganizationRelationExtMapper;

    @Resource
    private UserOrganizationExtMapper userOrganizationExtMapper;

    @Resource
    private UserInfoExtMapper userInfoExtMapper;

    @Override
    public Integer createUser(UserInfoDTO record) {
        Integer id = userInfoExtMapper.addUserInfo(record);
        UserOrganizationQuery query = new UserOrganizationQuery();
        query.orgCodeLike("default");
        List<UserOrganizationDTO> organizationDTOS =  userOrganizationExtMapper.selectByQuery(query);
        if(CollectionUtils.isEmpty(organizationDTOS)){
            throw new ServiceException(ResultCode.DEFAULT_USER_ORG_NOT_EXIST);
        }
        List<UserOrganizationRelationDTO> records = Lists.newArrayList();
        organizationDTOS.forEach(item->{
            UserOrganizationRelationDTO relationDTO = new UserOrganizationRelationDTO();
            relationDTO.setOrgId(item.getId());
            relationDTO.setUserId(id);
            relationDTO.init(BaseConstants.INT_1);
            records.add(relationDTO);
        });
        userOrganizationRelationExtMapper.batchInsert(records);
        return id;
    }

    @Override
    public boolean checkUserIdExist(String userId, Integer id) {
        UserInfoQuery query = new UserInfoQuery();
        if(Objects.nonNull(id)){
            query.idNotEqual(id).and();
        }
        query.userIdEqual(userId);
        List<UserInfoDTO> userInfoDTOS =  userInfoExtMapper.selectByQuery(query);
        return !CollectionUtils.isEmpty(userInfoDTOS);
    }

}
