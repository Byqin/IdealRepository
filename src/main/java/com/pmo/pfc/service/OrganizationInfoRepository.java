package com.pmo.pfc.service;

import com.pmo.pfc.dao.entity.OrganizationInfoEntity;

import java.util.List;

public interface OrganizationInfoRepository {

    List<OrganizationInfoEntity> queryByUserId(Integer id);

}
