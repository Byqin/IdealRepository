package com.pmo.pfc.api.dto;

import com.pmo.pfc.dao.entity.OrganizationInfoEntity;
import com.pmo.pfc.dao.entity.PermissionsInfoEntity;
import com.pmo.pfc.dao.entity.RoleInfoEntity;
import com.pmo.pfc.dao.entity.UserInfoEntity;
import lombok.Data;
import java.util.List;

@Data
public class UserInfoDTO extends UserInfoEntity {

    //用户所属组织集合
    private List<OrganizationInfoEntity> organizationEntities;

    // 用户单独的角色
    private List<RoleInfoEntity> roleEntities;

    //所属组织下的所有角色
    private List<RoleInfoEntity> orgRoleEntities;

    //所有权限
    private List<PermissionsInfoEntity> allPermissionsInfos;
}
