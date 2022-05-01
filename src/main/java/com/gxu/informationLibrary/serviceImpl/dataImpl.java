package com.gxu.informationLibrary.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.dao.authDao;
import com.gxu.informationLibrary.dao.dataManageDao;
import com.gxu.informationLibrary.dao.formManageDao;
import com.gxu.informationLibrary.entity.editEntity;
import com.gxu.informationLibrary.entity.response;
import com.gxu.informationLibrary.server.dataServer;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.gxu.informationLibrary.util.utils.getCookieByName;
import static com.gxu.informationLibrary.util.utils.updateCache;

@Service
@Transactional(rollbackFor = Exception.class)
public class dataImpl implements dataServer {
    final dataManageDao dataManage;
    private final StringRedisTemplate redisTemplate;
    private final authDao authManage;
    private final formManageDao formManage;

    public dataImpl(dataManageDao dataManage, StringRedisTemplate redisTemplate, authDao authManage, formManageDao formManage) {
        this.dataManage = dataManage;
        this.redisTemplate = redisTemplate;
        this.authManage = authManage;
        this.formManage = formManage;
    }

    @Override
    public response<List<Map<String, String>>> getTableColumn(int form_id) {
        List<Map<String, String>> data = new ArrayList<>();
        try {
            data = dataManage.getTableColumn(form_id);
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), data);
        }
        return new response<>(data);
    }

    @Override
    public response<String> insertData(String parma) {
        JSONObject insert = JSON.parseObject(parma);
        int form_id = insert.getInteger("form_id");
        Map<String, String> tb = dataManage.getTableByFormId(form_id);
        List<editEntity> columns = insert.getJSONArray("insert").toJavaList(editEntity.class);
        try {
            dataManage.insertData(tb.get("db_name"), tb.get("tb_name"), columns);
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), "");
        }
        return new response<>("");
    }

    @Override
    public response<String> deleteData(String parma) {
        try {
            JSONObject deleteJSON = JSON.parseObject(parma);
            int form_id = deleteJSON.getIntValue("form_id");
            Map<String, String> tb = dataManage.getTableByFormId(form_id);
            int record_id = deleteJSON.getIntValue("record_id");
            dataManage.deleteData(tb.get("db_name"), tb.get("tb_name"), record_id);
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), "");
        }

        return new response<>("");
    }

    @Override
    public response<List<JSONObject>> queryData(String parma, HttpServletRequest request) {
        List<JSONObject> data = new ArrayList<>();
        try {
            JSONObject query = JSON.parseObject(parma);
            int form_id = query.getIntValue("form_id");
            String form_name = formManage.queryFormName(form_id);
            Map<String, String> tb = dataManage.getTableByFormId(form_id);
            List<editEntity> columns = query.getJSONArray("columns").toJavaList(editEntity.class);
            String[] userCookie = Objects.requireNonNull(getCookieByName(request, "loginCookie")).split("_");
            HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
            String auth;
            if (!"系统管理员".equals(userCookie[2])){
                auth = hashOps.get("auth_" + userCookie[2]+"_"+form_name, "search");
            }else {
                auth="s1";
            }
            if (auth == null) {
                updateCache(userCookie, hashOps, authManage);
                auth = hashOps.get("auth_" + userCookie[2]+"_"+form_name, "search");
            }
            data = dataManage.queryData(tb.get("db_name"), tb.get("tb_name"), columns,"s0".equals(auth) , userCookie[1]);
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), data);
        }

        return new response<>(data);
    }

    @Override
    public response<String> updateData(String parma) {
        try {
            JSONObject updateJSON = JSON.parseObject(parma);
            int form_id = updateJSON.getIntValue("form_id");
            Map<String, String> tb = dataManage.getTableByFormId(form_id);
            int record_id = updateJSON.getIntValue("record_id");
            List<editEntity> updates = updateJSON.getJSONArray("update").toJavaList(editEntity.class);
            dataManage.updateData(tb.get("db_name"), tb.get("tb_name"), record_id, updates);
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), "");
        }
        return new response<>("");
    }

    public response<String> uploadFile(@NotNull MultipartFile file) {
        response<String> res = new response<>("");
        if (!file.isEmpty()) {
            try {
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream("./files/" + file.getOriginalFilename()));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
                res.setCode(500);
                res.setMsg("上传失败," + e.getMessage());
                return res;
            }
            res.setMsg("上传成功");

        } else {
            res.setCode(405);
            res.setMsg("上传失败，因为文件是空的.");
        }
        return res;
    }
}
