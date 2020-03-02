package com.pmo.pfc;

import com.alibaba.fastjson.JSONObject;
import com.pmo.pfc.dao.entity.UserInfoDTO;

public class JsonTest {

    public static void main(String[] args) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        System.out.println("撒大声地");
        userInfoDTO.setEmail("1");
        System.out.printf(JSONObject.toJSONString(userInfoDTO));
    }

}
