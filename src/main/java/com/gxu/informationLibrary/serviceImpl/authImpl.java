package com.gxu.informationLibrary.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.dao.authDao;
import com.gxu.informationLibrary.entity.response;
import com.gxu.informationLibrary.entity.roleAuth;
import com.gxu.informationLibrary.server.authServer;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class authImpl implements authServer {
    private final authDao auth;
    private final StringRedisTemplate redisTemplate;

    public authImpl(authDao auth, StringRedisTemplate redisTemplate) {
        this.auth = auth;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public List<roleAuth> getAuth(String role_name) {
        return auth.getAuth(role_name);
    }
    public roleAuth queryByName(String role_name) {
        return auth.queryByName(role_name);
    }
    @Override
    public List<roleAuth> editAuth(String parma) {
        JSONObject editObject= JSON.parseObject(parma);
        String role_name=editObject.getString("role_name");
        String form_name=editObject.getString("form_name");
        JSONArray array=editObject.getJSONArray("update");
        HashOperations<String,String,String> hashOps = redisTemplate.opsForHash();
        for (int i = 0; i < array.size(); i++) {
            JSONObject edit=array.getJSONObject(i);
            auth.editAuth(role_name,form_name , edit.getString("col_name"), edit.getString("value"));
            hashOps.delete("auth_"+role_name+"_"+form_name,edit.getString("col_name"));
        }
        return auth.getAuth("");
    }
    public response<String>checkAuth(String parma, HttpServletRequest request){
        String[] userCookie;
        JSONObject authJSON = JSON.parseObject(parma);
        String user =authJSON.getString("user");
        String option =authJSON.getString("option");
        return new response<>("");
    }
}
