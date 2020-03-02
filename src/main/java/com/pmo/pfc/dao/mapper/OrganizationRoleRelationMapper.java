package com.pmo.pfc.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.pmo.pfc.dao.entity.OrganizationRoleRelationDTO;
import com.pmo.pfc.dao.query.OrganizationRoleRelationQuery;

@Repository
public interface OrganizationRoleRelationMapper {

    List<OrganizationRoleRelationDTO> selectByQuery(@Param("data") OrganizationRoleRelationQuery query);

    List<OrganizationRoleRelationDTO> selectByPrimary(@Param("id") Integer id);

    int addUserInfoWithNull(@Param("record")OrganizationRoleRelationDTO record);

    int addUserInfo(OrganizationRoleRelationDTO record);
    
    int batchInsert(@Param("list")List<OrganizationRoleRelationDTO> lists);

    int updateByPrimary(@Param("id")Integer id,@Param("record")OrganizationRoleRelationDTO record);

    int updateByPrimaryWithNull(@Param("id")Integer id,@Param("record")OrganizationRoleRelationDTO record);

    int updateByQuery(@Param("data")OrganizationRoleRelationQuery query,@Param("record")OrganizationRoleRelationDTO record);

    int updateByQueryWithNull(@Param("data")OrganizationRoleRelationQuery query,@Param("record")OrganizationRoleRelationDTO record);

    int deleteByPrimary(@Param("id") Integer id);

    int deleteByQuery(@Param("data")OrganizationRoleRelationQuery query);

}