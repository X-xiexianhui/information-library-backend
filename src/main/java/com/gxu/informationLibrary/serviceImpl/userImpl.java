package com.gxu.informationLibrary.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.gxu.informationLibrary.dao.userDao;
import com.gxu.informationLibrary.entity.userInfo;
import com.gxu.informationLibrary.server.userServer;
import org.springframework.util.DigestUtils;

import java.util.List;

public class userImpl implements userServer {
    final userDao userManage;

    public userImpl(userDao userManage) {
        this.userManage = userManage;
    }

    @Override
    public List<userInfo> addUser(String param) {
        userInfo user= JSON.parseObject(param).toJavaObject(userInfo.class);
        String md5Password = DigestUtils.md5DigestAsHex(user.getPwd().getBytes());
        user.setPwd(md5Password);
        userManage.addUser(user);
        return userManage.queryUser("");
    }

    @Override
    public List<userInfo> deleteUser(String user_id) {
        return null;
    }

    @Override
    public List<userInfo> queryUser(String user_name) {
        return null;
    }

    @Override
    public List<userInfo> editUser(String user) {
        return null;
    }
}
