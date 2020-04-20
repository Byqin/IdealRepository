package com.pmo.pfc.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.pmo.pfc.dao.entity.PermissionsInfoEntity;
import com.pmo.pfc.dao.query.PermissionsInfoQuery;

@Repository
public interface PermissionsInfoMapper {

    List<PermissionsInfoEntity> selectByQuery(@Param("data") PermissionsInfoQuery query);

    List<PermissionsInfoEntity> selectByPrimary(@Param("id") Integer id);

    int addUserInfoWithNull(@Param("record")PermissionsInfoEntity record);

    int addUserInfo(PermissionsInfoEntity record);
    
    int batchInsert(@Param("list")List<PermissionsInfoEntity> lists);

    int updateByPrimary(@Param("id")Integer id,@Param("record")PermissionsInfoEntity record);

    int updateByPrimaryWithNull(@Param("id")Integer id,@Param("record")PermissionsInfoEntity record);

    int updateByQuery(@Param("data")PermissionsInfoQuery query,@Param("record")PermissionsInfoEntity record);

    int updateByQueryWithNull(@Param("data")PermissionsInfoQuery query,@Param("record")PermissionsInfoEntity record);

    int deleteByPrimary(@Param("id") Integer id);

    int deleteByQuery(@Param("data")PermissionsInfoQuery query);

}