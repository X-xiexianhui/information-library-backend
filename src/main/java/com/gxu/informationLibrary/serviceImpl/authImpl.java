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
import java.util.Objects;

import static com.gxu.informationLibrary.util.utils.getCookieByName;

@Service
@Transactional(rollbackFor = Exception.class)
public class authImpl implements authServer {
    private final authDao authManage;
    private final StringRedisTemplate redisTemplate;

    public authImpl(authDao authManage, StringRedisTemplate redisTemplate) {
        this.authManage = authManage;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public List<roleAuth> getAuth(String role_name) {
        return authManage.getAuth(role_name);
    }
    public roleAuth queryByName(String role_name) {
        return authManage.queryByName(role_name);
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
            authManage.editAuth(role_name,form_name , edit.getString("col_name"), edit.getString("value"));
            hashOps.delete("auth_"+role_name+"_"+form_name,edit.getString("col_name"));
        }
        return authManage.getAuth("");
    }
    public response<String>checkAuth(String parma, HttpServletRequest request){
        HashOperations<String,String,String> hashOps = redisTemplate.opsForHash();
        String[] userCookie = Objects.requireNonNull(getCookieByName(request, "loginCookie")).split("_") ;
        JSONObject authJSON = JSON.parseObject(parma);
        String user_id =userCookie[1];
        String user =authJSON.getString("user");
        String option =authJSON.getString("option");
        String auth = hashOps.get("auth_"+userCookie[2],option);
        if (auth==null){
            roleAuth cache=authManage.queryByName(userCookie[2]);
            String key="auth_"+cache.getRole_name()+"_"+cache.getForm_name();
            hashOps.put(key,"add",cache.getAddAuth());
            hashOps.put(key,"del",cache.getDel());
            hashOps.put(key,"search",cache.getSearch());
            hashOps.put(key,"edit",cache.getEditAuth());
        }
        switch (auth){

        }
        return new response<>("");
    }
}
