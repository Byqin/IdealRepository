package com.pmo.pfc.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.pmo.pfc.dao.entity.UserOrganizationDTO;
import com.pmo.pfc.dao.query.UserOrganizationQuery;

@Repository
public interface UserOrganizationMapper {

    List<UserOrganizationDTO> selectByQuery(@Param("data") UserOrganizationQuery query);

    List<UserOrganizationDTO> selectByPrimary(@Param("id") Integer id);

    int addUserInfoWithNull(@Param("record")UserOrganizationDTO record);

    int addUserInfo(UserOrganizationDTO record);
    
    int batchInsert(@Param("list")List<UserOrganizationDTO> lists);

    int updateByPrimary(@Param("id")Integer id,@Param("record")UserOrganizationDTO record);

    int updateByPrimaryWithNull(@Param("id")Integer id,@Param("record")UserOrganizationDTO record);

    int updateByQuery(@Param("data")UserOrganizationQuery query,@Param("record")UserOrganizationDTO record);

    int updateByQueryWithNull(@Param("data")UserOrganizationQuery query,@Param("record")UserOrganizationDTO record);

    int deleteByPrimary(@Param("id") Integer id);

    int deleteByQuery(@Param("data")UserOrganizationQuery query);

}