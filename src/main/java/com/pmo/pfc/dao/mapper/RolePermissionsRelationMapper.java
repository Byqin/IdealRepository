package com.pmo.pfc.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.pmo.pfc.dao.entity.RolePermissionsRelationEntity;
import com.pmo.pfc.dao.query.RolePermissionsRelationQuery;

@Repository
public interface RolePermissionsRelationMapper {

    List<RolePermissionsRelationEntity> selectByQuery(@Param("data") RolePermissionsRelationQuery query);

    List<RolePermissionsRelationEntity> selectByPrimary(@Param("id") Integer id);

    int addUserInfoWithNull(@Param("record")RolePermissionsRelationEntity record);

    int addUserInfo(RolePermissionsRelationEntity record);
    
    int batchInsert(@Param("list")List<RolePermissionsRelationEntity> lists);

    int updateByPrimary(@Param("id")Integer id,@Param("record")RolePermissionsRelationEntity record);

    int updateByPrimaryWithNull(@Param("id")Integer id,@Param("record")RolePermissionsRelationEntity record);

    int updateByQuery(@Param("data")RolePermissionsRelationQuery query,@Param("record")RolePermissionsRelationEntity record);

    int updateByQueryWithNull(@Param("data")RolePermissionsRelationQuery query,@Param("record")RolePermissionsRelationEntity record);

    int deleteByPrimary(@Param("id") Integer id);

    int deleteByQuery(@Param("data")RolePermissionsRelationQuery query);

}