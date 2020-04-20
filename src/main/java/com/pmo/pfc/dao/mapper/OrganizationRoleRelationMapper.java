package com.pmo.pfc.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.pmo.pfc.dao.entity.OrganizationRoleRelationEntity;
import com.pmo.pfc.dao.query.OrganizationRoleRelationQuery;

@Repository
public interface OrganizationRoleRelationMapper {

    List<OrganizationRoleRelationEntity> selectByQuery(@Param("data") OrganizationRoleRelationQuery query);

    List<OrganizationRoleRelationEntity> selectByPrimary(@Param("id") Integer id);

    int addUserInfoWithNull(@Param("record")OrganizationRoleRelationEntity record);

    int addUserInfo(OrganizationRoleRelationEntity record);
    
    int batchInsert(@Param("list")List<OrganizationRoleRelationEntity> lists);

    int updateByPrimary(@Param("id")Integer id,@Param("record")OrganizationRoleRelationEntity record);

    int updateByPrimaryWithNull(@Param("id")Integer id,@Param("record")OrganizationRoleRelationEntity record);

    int updateByQuery(@Param("data")OrganizationRoleRelationQuery query,@Param("record")OrganizationRoleRelationEntity record);

    int updateByQueryWithNull(@Param("data")OrganizationRoleRelationQuery query,@Param("record")OrganizationRoleRelationEntity record);

    int deleteByPrimary(@Param("id") Integer id);

    int deleteByQuery(@Param("data")OrganizationRoleRelationQuery query);

}