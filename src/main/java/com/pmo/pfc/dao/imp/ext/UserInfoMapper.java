package com.pmo.pfc.dao.imp.ext;

import com.pmo.pfc.dao.entity.UserInfoDTO;
import com.pmo.pfc.dao.query.UserInfoQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserInfoMapper {

    UserInfoDTO selectUserInfoByUserId(@Param("userId") String userId);

    List<UserInfoDTO> selectByQuery(@Param("data") UserInfoQuery userInfoQuery);

    List<UserInfoDTO> selectByPrimary(@Param("id") Long id);

    int addUserInfoWithNull(UserInfoDTO userInfoDTO);

    int addUserInfo(@Param("record")UserInfoDTO userInfoDTO);

    int updateByPrimary(@Param("id")Long id,@Param("record")UserInfoDTO record);

    int updateByPrimaryWithNull(@Param("id")Long id,@Param("record")UserInfoDTO record);

    int updateByQuery(@Param("data")UserInfoQuery query,@Param("record")UserInfoDTO record);

    int updateByQueryWithNull(@Param("data")UserInfoQuery query,@Param("record")UserInfoDTO record);

    int deleteByPrimary(@Param("id") Long id);

    int deleteByQuery(@Param("data")UserInfoQuery query);

}
