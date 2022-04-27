package com.gxu.informationLibrary.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.dao.userDao;
import com.gxu.informationLibrary.entity.userInfo;
import com.gxu.informationLibrary.server.userServer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(rollbackFor = Exception.class)
public class userImpl implements userServer {
    final userDao userManage;

    public userImpl(userDao userManage) {
        this.userManage = userManage;
    }

    @Override
    public List<userInfo> addUser(String param) {
        userInfo user= JSON.parseObject(param).toJavaObject(userInfo.class);
        user.setUser_pwd("user_pwd"+user.getUser_id());
        String md5Password = DigestUtils.md5DigestAsHex(user.getUser_pwd().getBytes());
        user.setUser_pwd(md5Password);
        userManage.addUser(user);
        return userManage.queryUser("");
    }

    @Override
    public List<userInfo> deleteUser(String user_id) {
        userManage.deleteUser(user_id);
        return userManage.queryUser("");
    }

    @Override
    public List<userInfo> queryUser(String user_name) {
        return userManage.queryUser(user_name);
    }

    @Override
    public List<userInfo> editUser(String param) {
        JSONObject editJSON = JSON.parseObject(param);
        String user_id =editJSON.getString("user_id");
        JSONArray array=editJSON.getJSONArray("update");
        for (int i = 0; i < array.size(); i++) {
            JSONObject object=array.getJSONObject(i);
            userManage.editUser(user_id, object.getString("col_name"), object.getString("value") );
        }
        return userManage.queryUser("");
    }

    @Override
    public void login(String parma, HttpServletResponse response) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
    }
}
