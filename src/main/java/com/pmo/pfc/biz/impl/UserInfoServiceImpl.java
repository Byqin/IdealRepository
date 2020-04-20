package com.pmo.pfc.biz.impl;

import com.pmo.pfc.api.param.UserInfoParam;
import com.pmo.pfc.biz.UserInfoService;
import com.pmo.pfc.common.ResponseDTO;
import com.pmo.pfc.common.ResultCode;
import com.pmo.pfc.common.ServiceException;
import com.pmo.pfc.dao.entity.UserInfoDTO;
import com.pmo.pfc.dao.mapper.ext.UserInfoExtMapper;
import com.pmo.pfc.dao.query.UserInfoQuery;
import com.pmo.pfc.service.UserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoExtMapper userInfoDao;

    @Resource
    private UserInfoRepository userInfoRepository;

    public UserInfoServiceImpl(){
        log.info("=====================================");
    }

    @Override
    public String getUserInfo(String userId) {
        UserInfoDTO userInfoDTO =  userInfoDao.selectUserInfoByUserId(userId);
        return Objects.isNull(userInfoDTO) ? "未找到数据": userInfoDTO.toString();
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public String saveInfo(UserInfoParam param) {
        ResponseDTO<Integer> responseDTO = ResponseDTO.newInstance();
        if(userInfoRepository.checkUserIdExist(param.getUserId(),param.getId())){
            throw new ServiceException(ResultCode.USER_ID_EXIST);
        }
        UserInfoDTO record = new UserInfoDTO();
        BeanUtils.copyProperties(param,record);
        if(Objects.nonNull(param.getId())) {
            List<UserInfoDTO> userInfoDTOS =  userInfoDao.selectByPrimary(param.getId());
            if(CollectionUtils.isEmpty(userInfoDTOS)){
                 throw new ServiceException(ResultCode.USER_NOT_EXIST);
            }
            userInfoDao.updateByPrimaryWithNull(param.getId(),record);
        }else{
            userInfoRepository.createUser(record);
        }
        responseDTO.setData(record.getId());
        return responseDTO.toString();
    }

    @Override
    public String queryInfo(String userId) {
        UserInfoQuery query = new UserInfoQuery();
        query.userIdEqual("admin")
                .or()
                .beforeBracket()
                .userIdLike("123")
                .and()
                .userIdIn(Arrays.asList(new String[]{"qwqweqw"}))
                .afterBracket();
        List<UserInfoDTO> userInfoDTOS = userInfoDao.selectByQuery(query);
        return ResponseDTO.newInstance(userInfoDTOS).toString();
    }

}
