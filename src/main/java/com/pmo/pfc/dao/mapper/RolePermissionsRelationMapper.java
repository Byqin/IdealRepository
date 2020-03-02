package com.pmo.pfc.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.pmo.pfc.dao.entity.RolePermissionsRelationDTO;
import com.pmo.pfc.dao.query.RolePermissionsRelationQuery;

@Repository
public interface RolePermissionsRelationMapper {

    List<RolePermissionsRelationDTO> selectByQuery(@Param("data") RolePermissionsRelationQuery query);

    List<RolePermissionsRelationDTO> selectByPrimary(@Param("id") Integer id);

    int addUserInfoWithNull(@Param("record")RolePermissionsRelationDTO record);

    int addUserInfo(RolePermissionsRelationDTO record);
    
    int batchInsert(@Param("list")List<RolePermissionsRelationDTO> lists);

    int updateByPrimary(@Param("id")Integer id,@Param("record")RolePermissionsRelationDTO record);

    int updateByPrimaryWithNull(@Param("id")Integer id,@Param("record")RolePermissionsRelationDTO record);

    int updateByQuery(@Param("data")RolePermissionsRelationQuery query,@Param("record")RolePermissionsRelationDTO record);

    int updateByQueryWithNull(@Param("data")RolePermissionsRelationQuery query,@Param("record")RolePermissionsRelationDTO record);

    int deleteByPrimary(@Param("id") Integer id);

    int deleteByQuery(@Param("data")RolePermissionsRelationQuery query);

}