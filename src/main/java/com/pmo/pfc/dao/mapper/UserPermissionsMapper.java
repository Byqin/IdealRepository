package com.pmo.pfc.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.pmo.pfc.dao.entity.UserPermissionsDTO;
import com.pmo.pfc.dao.query.UserPermissionsQuery;

@Repository
public interface UserPermissionsMapper {

    List<UserPermissionsDTO> selectByQuery(@Param("data") UserPermissionsQuery query);

    List<UserPermissionsDTO> selectByPrimary(@Param("id") Integer id);

    int addUserInfoWithNull(@Param("record")UserPermissionsDTO record);

    int addUserInfo(UserPermissionsDTO record);
    
    int batchInsert(@Param("list")List<UserPermissionsDTO> lists);

    int updateByPrimary(@Param("id")Integer id,@Param("record")UserPermissionsDTO record);

    int updateByPrimaryWithNull(@Param("id")Integer id,@Param("record")UserPermissionsDTO record);

    int updateByQuery(@Param("data")UserPermissionsQuery query,@Param("record")UserPermissionsDTO record);

    int updateByQueryWithNull(@Param("data")UserPermissionsQuery query,@Param("record")UserPermissionsDTO record);

    int deleteByPrimary(@Param("id") Integer id);

    int deleteByQuery(@Param("data")UserPermissionsQuery query);

}