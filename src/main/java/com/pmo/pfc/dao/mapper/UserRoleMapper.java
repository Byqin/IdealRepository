package com.pmo.pfc.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.pmo.pfc.dao.entity.UserRoleDTO;
import com.pmo.pfc.dao.query.UserRoleQuery;

@Repository
public interface UserRoleMapper {

    List<UserRoleDTO> selectByQuery(@Param("data") UserRoleQuery query);

    List<UserRoleDTO> selectByPrimary(@Param("id") Integer id);

    int addUserInfoWithNull(@Param("record")UserRoleDTO record);

    int addUserInfo(UserRoleDTO record);
    
    int batchInsert(@Param("list")List<UserRoleDTO> lists);

    int updateByPrimary(@Param("id")Integer id,@Param("record")UserRoleDTO record);

    int updateByPrimaryWithNull(@Param("id")Integer id,@Param("record")UserRoleDTO record);

    int updateByQuery(@Param("data")UserRoleQuery query,@Param("record")UserRoleDTO record);

    int updateByQueryWithNull(@Param("data")UserRoleQuery query,@Param("record")UserRoleDTO record);

    int deleteByPrimary(@Param("id") Integer id);

    int deleteByQuery(@Param("data")UserRoleQuery query);

}