package com.pmo.pfc.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.pmo.pfc.dao.entity.UserInfoEntity;
import com.pmo.pfc.dao.query.UserInfoQuery;

@Repository
public interface UserInfoMapper {

    List<UserInfoEntity> selectByQuery(@Param("data") UserInfoQuery query);

    List<UserInfoEntity> selectByPrimary(@Param("id") Integer id);

    int addUserInfoWithNull(@Param("record")UserInfoEntity record);

    int addUserInfo(UserInfoEntity record);
    
    int batchInsert(@Param("list")List<UserInfoEntity> lists);

    int updateByPrimary(@Param("id")Integer id,@Param("record")UserInfoEntity record);

    int updateByPrimaryWithNull(@Param("id")Integer id,@Param("record")UserInfoEntity record);

    int updateByQuery(@Param("data")UserInfoQuery query,@Param("record")UserInfoEntity record);

    int updateByQueryWithNull(@Param("data")UserInfoQuery query,@Param("record")UserInfoEntity record);

    int deleteByPrimary(@Param("id") Integer id);

    int deleteByQuery(@Param("data")UserInfoQuery query);

}