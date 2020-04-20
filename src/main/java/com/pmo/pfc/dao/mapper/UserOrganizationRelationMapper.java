package com.pmo.pfc.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.pmo.pfc.dao.entity.UserOrganizationRelationEntity;
import com.pmo.pfc.dao.query.UserOrganizationRelationQuery;

@Repository
public interface UserOrganizationRelationMapper {

    List<UserOrganizationRelationEntity> selectByQuery(@Param("data") UserOrganizationRelationQuery query);

    List<UserOrganizationRelationEntity> selectByPrimary(@Param("id") Integer id);

    int addUserInfoWithNull(@Param("record")UserOrganizationRelationEntity record);

    int addUserInfo(UserOrganizationRelationEntity record);
    
    int batchInsert(@Param("list")List<UserOrganizationRelationEntity> lists);

    int updateByPrimary(@Param("id")Integer id,@Param("record")UserOrganizationRelationEntity record);

    int updateByPrimaryWithNull(@Param("id")Integer id,@Param("record")UserOrganizationRelationEntity record);

    int updateByQuery(@Param("data")UserOrganizationRelationQuery query,@Param("record")UserOrganizationRelationEntity record);

    int updateByQueryWithNull(@Param("data")UserOrganizationRelationQuery query,@Param("record")UserOrganizationRelationEntity record);

    int deleteByPrimary(@Param("id") Integer id);

    int deleteByQuery(@Param("data")UserOrganizationRelationQuery query);

}