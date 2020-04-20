package com.pmo.pfc.api.dto;

import com.pmo.pfc.dao.entity.OrganizationInfoEntity;
import com.pmo.pfc.dao.entity.RoleInfoEntity;
import com.pmo.pfc.dao.entity.UserInfoEntity;
import lombok.Data;
import java.util.List;

@Data
public class UserInfoDTO extends UserInfoEntity {

    private List<OrganizationInfoEntity> organizationEntities;

    private List<RoleInfoEntity> roleEntities;
}
