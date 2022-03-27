package com.gxu.informationLibrary.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.dao.tableManagerDao;
import com.gxu.informationLibrary.entity.Columns;
import com.gxu.informationLibrary.entity.column;
import com.gxu.informationLibrary.server.tbManageServer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class tbManageImpl implements tbManageServer {
    final tableManagerDao tbManage;

    public tbManageImpl(tableManagerDao tbManage) {
        this.tbManage = tbManage;
    }

    @Override
    @Transactional
    public List<JSONObject> createTable(String Param) {
        JSONObject jsonParam= JSONObject.parseObject(Param);
        String dbName=jsonParam.getString("dbName");
        String tbName=jsonParam.getString("tbName");
        List<column>columns=new Columns(jsonParam.getJSONArray("column"),dbName,tbName).getColumns();
        List<String>pks=new ArrayList<>();
        for (column c: columns) {
            if (c.isPK()){
                pks.add(c.getCol_name());
            }
        }
        tbManage.createTable(columns,pks, dbName, tbName);
        return this.tbManage.getColumnList(dbName,tbName);
    }

    @Override
    public void deleteTable(String dbName, String tbName) {
       tbManage.deleteTable(dbName,tbName);
    }
    public List<JSONObject>test(String dbName,String tbName){
        return this.tbManage.test(dbName,tbName);
    }
}
