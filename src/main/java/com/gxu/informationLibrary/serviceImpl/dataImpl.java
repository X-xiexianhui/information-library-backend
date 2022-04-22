package com.gxu.informationLibrary.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.dao.dataManageDao;
import com.gxu.informationLibrary.server.dataServer;
import netscape.javascript.JSObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor=Exception.class)
public class dataImpl implements dataServer {
    final dataManageDao dataManage;

    public dataImpl(dataManageDao dataManage) {
        this.dataManage = dataManage;
    }

    @Override
    public List<JSONObject> insertData(String parma) {
        JSONObject insert= JSON.parseObject(parma);
        String db_name=insert.getString("db_name");
        String tb_name=insert.getString("tb_name");
        List<String> key=new ArrayList<>(insert.keySet());
        List<Object>value=new ArrayList<>();
        for (String k:key) {
            value.add(insert.get(k));
        }
        dataManage.insertData(db_name, tb_name, key, value);
        return dataManage.queryData(db_name,tb_name , new ArrayList<>(), false);
    }

    @Override
    public List<JSONObject> deleteData(String record_id) {
        return null;
    }

    @Override
    public List<JSONObject> queryData(String parma) {
        JSONObject query=JSON.parseObject(parma);
        String db_name=query.getString("db_name");
        String tb_name=query.getString("tb_name");
        List<String>columns=query.getJSONArray("columns").toJavaList(String.class);
        return dataManage.queryData(db_name,tb_name,columns,false);
    }

    @Override
    public List<JSONObject> updateData(String parma) {
        return null;
    }
}
