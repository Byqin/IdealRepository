package com.pmo.pfc;

import com.alibaba.fastjson.JSONObject;
import com.pmo.pfc.dao.entity.UserInfoEntity;

public class JsonTest {

    public static void main(String[] args) {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        System.out.println("撒大声地");
        userInfoEntity.setEmail("1");
        System.out.printf(JSONObject.toJSONString(userInfoEntity));
    }

}
