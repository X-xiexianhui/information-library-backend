package com.gxu.informationLibrary.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.dao.dataManageDao;
import com.gxu.informationLibrary.entity.editEntity;
import com.gxu.informationLibrary.server.dataServer;
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
        List<editEntity>columns=insert.getJSONArray("insert").toJavaList(editEntity.class);
        dataManage.insertData(db_name, tb_name,columns);
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
        List<editEntity>columns=query.getJSONArray("columns").toJavaList(editEntity.class);
        return dataManage.queryData(db_name,tb_name,columns,false);
    }

    @Override
    public List<JSONObject> updateData(String parma) {
        JSONObject updateJSON =JSON.parseObject(parma);
        String db_name= updateJSON.getString("db_name");
        String tb_name=updateJSON.getString("tb_name");
        List<editEntity> updates=updateJSON.getJSONArray("update").toJavaList(editEntity.class);
        dataManage.updateData(db_name,tb_name , updates);
        return dataManage.queryData(db_name,tb_name , new ArrayList<>(), false);
    }
}
