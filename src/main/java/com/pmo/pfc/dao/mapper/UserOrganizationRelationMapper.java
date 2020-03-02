package com.pmo.pfc.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.pmo.pfc.dao.entity.UserOrganizationRelationDTO;
import com.pmo.pfc.dao.query.UserOrganizationRelationQuery;

@Repository
public interface UserOrganizationRelationMapper {

    List<UserOrganizationRelationDTO> selectByQuery(@Param("data") UserOrganizationRelationQuery query);

    List<UserOrganizationRelationDTO> selectByPrimary(@Param("id") Integer id);

    int addUserInfoWithNull(@Param("record")UserOrganizationRelationDTO record);

    int addUserInfo(UserOrganizationRelationDTO record);
    
    int batchInsert(@Param("list")List<UserOrganizationRelationDTO> lists);

    int updateByPrimary(@Param("id")Integer id,@Param("record")UserOrganizationRelationDTO record);

    int updateByPrimaryWithNull(@Param("id")Integer id,@Param("record")UserOrganizationRelationDTO record);

    int updateByQuery(@Param("data")UserOrganizationRelationQuery query,@Param("record")UserOrganizationRelationDTO record);

    int updateByQueryWithNull(@Param("data")UserOrganizationRelationQuery query,@Param("record")UserOrganizationRelationDTO record);

    int deleteByPrimary(@Param("id") Integer id);

    int deleteByQuery(@Param("data")UserOrganizationRelationQuery query);

}