package com.gxu.informationLibrary.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.dao.userDao;
import com.gxu.informationLibrary.entity.response;
import com.gxu.informationLibrary.entity.userInfo;
import com.gxu.informationLibrary.server.userServer;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.gxu.informationLibrary.util.utils.setCookie;

@Service
@Transactional(rollbackFor = Exception.class)
public class userImpl implements userServer {
    final userDao userManage;
    private final StringRedisTemplate redisTemplate;

    public userImpl(userDao userManage, StringRedisTemplate redisTemplate) {
        this.userManage = userManage;
        this.redisTemplate = redisTemplate;
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
    public response<String> login(String parma, HttpServletResponse res) {
        response<String>data=new response<>("");
        try {
            String uuid = UUID.randomUUID().toString();
            JSONObject userData=JSON.parseObject(parma);
            Map<String,String>user=userManage.checkUser(userData.getString("user_id"));
            String md5Password = DigestUtils.md5DigestAsHex(userData.getString("user_pwd").getBytes());
            if (user == null){
                data.setCode(403);
                data.setMsg("用户不存在");
                data.setData("");
                return data;
            }
            if (!user.get("user_pwd").equals(md5Password)){
                data.setCode(403);
                data.setMsg("账号或密码错误");
                data.setData("");
                return data;
            }
            String value = uuid+"_"+userData.getString("user_id")+"_"+user.get("user_role");
            setCookie(res,"loginCookie",value,2*60*60);
            ValueOperations<String,String> ops = redisTemplate.opsForValue();
            ops.set("loginCookie_"+userData.getString("user_id"),value,2*60*60, TimeUnit.SECONDS);
        }catch (Exception e){
            data.setCode(500);
            data.setMsg(e.getCause().getMessage());
            data.setData("");
            return data;
        }

        return data;
    }
}
