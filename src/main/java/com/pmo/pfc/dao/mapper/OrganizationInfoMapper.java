package com.pmo.pfc.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.pmo.pfc.dao.entity.OrganizationInfoEntity;
import com.pmo.pfc.dao.query.OrganizationInfoQuery;

@Repository
public interface OrganizationInfoMapper {

    List<OrganizationInfoEntity> selectByQuery(@Param("data") OrganizationInfoQuery query);

    List<OrganizationInfoEntity> selectByPrimary(@Param("id") Integer id);

    int addUserInfoWithNull(@Param("record")OrganizationInfoEntity record);

    int addUserInfo(OrganizationInfoEntity record);
    
    int batchInsert(@Param("list")List<OrganizationInfoEntity> lists);

    int updateByPrimary(@Param("id")Integer id,@Param("record")OrganizationInfoEntity record);

    int updateByPrimaryWithNull(@Param("id")Integer id,@Param("record")OrganizationInfoEntity record);

    int updateByQuery(@Param("data")OrganizationInfoQuery query,@Param("record")OrganizationInfoEntity record);

    int updateByQueryWithNull(@Param("data")OrganizationInfoQuery query,@Param("record")OrganizationInfoEntity record);

    int deleteByPrimary(@Param("id") Integer id);

    int deleteByQuery(@Param("data")OrganizationInfoQuery query);

}