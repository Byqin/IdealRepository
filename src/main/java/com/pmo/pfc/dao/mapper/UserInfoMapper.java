package com.pmo.pfc.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.pmo.pfc.dao.entity.UserInfoDTO;
import com.pmo.pfc.dao.query.UserInfoQuery;

@Repository
public interface UserInfoMapper {

    List<UserInfoDTO> selectByQuery(@Param("data") UserInfoQuery query);

    List<UserInfoDTO> selectByPrimary(@Param("id") Integer id);

    int addUserInfoWithNull(@Param("record")UserInfoDTO record);

    int addUserInfo(UserInfoDTO record);
    
    int batchInsert(@Param("list")List<UserInfoDTO> lists);

    int updateByPrimary(@Param("id")Integer id,@Param("record")UserInfoDTO record);

    int updateByPrimaryWithNull(@Param("id")Integer id,@Param("record")UserInfoDTO record);

    int updateByQuery(@Param("data")UserInfoQuery query,@Param("record")UserInfoDTO record);

    int updateByQueryWithNull(@Param("data")UserInfoQuery query,@Param("record")UserInfoDTO record);

    int deleteByPrimary(@Param("id") Integer id);

    int deleteByQuery(@Param("data")UserInfoQuery query);

}