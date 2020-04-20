package com.pmo.pfc.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.pmo.pfc.dao.entity.UserRoleRelationEntity;
import com.pmo.pfc.dao.query.UserRoleRelationQuery;

@Repository
public interface UserRoleRelationMapper {

    List<UserRoleRelationEntity> selectByQuery(@Param("data") UserRoleRelationQuery query);

    List<UserRoleRelationEntity> selectByPrimary(@Param("id") Integer id);

    int addUserInfoWithNull(@Param("record")UserRoleRelationEntity record);

    int addUserInfo(UserRoleRelationEntity record);
    
    int batchInsert(@Param("list")List<UserRoleRelationEntity> lists);

    int updateByPrimary(@Param("id")Integer id,@Param("record")UserRoleRelationEntity record);

    int updateByPrimaryWithNull(@Param("id")Integer id,@Param("record")UserRoleRelationEntity record);

    int updateByQuery(@Param("data")UserRoleRelationQuery query,@Param("record")UserRoleRelationEntity record);

    int updateByQueryWithNull(@Param("data")UserRoleRelationQuery query,@Param("record")UserRoleRelationEntity record);

    int deleteByPrimary(@Param("id") Integer id);

    int deleteByQuery(@Param("data")UserRoleRelationQuery query);

}