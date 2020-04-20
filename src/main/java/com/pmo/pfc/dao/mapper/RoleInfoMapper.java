package com.pmo.pfc.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.pmo.pfc.dao.entity.RoleInfoEntity;
import com.pmo.pfc.dao.query.RoleInfoQuery;

@Repository
public interface RoleInfoMapper {

    List<RoleInfoEntity> selectByQuery(@Param("data") RoleInfoQuery query);

    List<RoleInfoEntity> selectByPrimary(@Param("id") Integer id);

    int addUserInfoWithNull(@Param("record")RoleInfoEntity record);

    int addUserInfo(RoleInfoEntity record);
    
    int batchInsert(@Param("list")List<RoleInfoEntity> lists);

    int updateByPrimary(@Param("id")Integer id,@Param("record")RoleInfoEntity record);

    int updateByPrimaryWithNull(@Param("id")Integer id,@Param("record")RoleInfoEntity record);

    int updateByQuery(@Param("data")RoleInfoQuery query,@Param("record")RoleInfoEntity record);

    int updateByQueryWithNull(@Param("data")RoleInfoQuery query,@Param("record")RoleInfoEntity record);

    int deleteByPrimary(@Param("id") Integer id);

    int deleteByQuery(@Param("data")RoleInfoQuery query);

}