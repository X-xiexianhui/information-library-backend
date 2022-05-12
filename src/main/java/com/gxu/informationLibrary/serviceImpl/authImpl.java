package com.gxu.informationLibrary.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.dao.authDao;
import com.gxu.informationLibrary.dao.formManageDao;
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
import static com.gxu.informationLibrary.util.utils.updateCache;

@Service
@Transactional(rollbackFor = Exception.class)
public class authImpl implements authServer {
    private final authDao authManage;
    private final StringRedisTemplate redisTemplate;
    private final formManageDao formManage;

    public authImpl(authDao authManage, StringRedisTemplate redisTemplate, formManageDao formManage) {
        this.authManage = authManage;
        this.redisTemplate = redisTemplate;
        this.formManage = formManage;
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
        String[] userCookie = Objects.requireNonNull(getCookieByName(request, "login_cookie")).split("_") ;
        JSONObject authJSON = JSON.parseObject(parma);
        String user_id =userCookie[1];
        String user =authJSON.getString("user");
        String option =authJSON.getString("option");
        int form_id = authJSON.getIntValue("form_id");
        String form_name=formManage.queryFormName(form_id);
        if (!"系统管理员".equals(userCookie[2])){
            String auth = hashOps.get("auth_"+userCookie[2]+"_"+form_name,option);
            if (auth==null){
                updateCache(userCookie, hashOps, authManage,form_name);
                auth = hashOps.get("auth_"+userCookie[2]+"_"+form_name,option);
            }
            if ("w0".equals(auth)){
                return new response<>(403,"您没有添加数据权限","");
            }
            if ("u0".equals(auth)){
                return new response<>(403,"您没有修改数据权限","");
            }
            if ("d0".equals(auth)){
                return new response<>(403,"您没有删除数据权限","");
            }
            if ("u1".equals(auth)&&!user_id.equals(user)){
                return new response<>(403,"您没有修改其他用户数据权限","");
            }
            if ("d1".equals(auth)&&!user_id.equals(user)){
                return new response<>(403,"您没有删除其他用户数据权限","");
            }
        }
        return new response<>("");
    }
}
