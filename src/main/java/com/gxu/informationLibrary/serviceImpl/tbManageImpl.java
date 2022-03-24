package com.gxu.informationLibrary.serviceImpl;

import com.gxu.informationLibrary.dao.tableManagerDao;
import com.gxu.informationLibrary.entity.Columns;
import com.gxu.informationLibrary.entity.column;
import com.gxu.informationLibrary.server.tbManageServer;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

@Service
public class tbManageImpl implements tbManageServer {
    final tableManagerDao tbManage;

    public tbManageImpl(tableManagerDao tbManage) {
        this.tbManage = tbManage;
    }

    @Override
    @Transient
    public void createTable(String Param) {
        JSONObject jsonParam= new JSONObject(Param);
        String dbName=jsonParam.getString("dbName");
        String tbName=jsonParam.getString("tbName");
        List<column>columns=new Columns(jsonParam.getJSONArray("column"),dbName,tbName).getColumns();
        List<String>pks=new ArrayList<>();
        for (column c: columns) {
            if (c.isPK()){
                pks.add(c.getColName());
            }
        }
        tbManage.createTable(columns,pks, dbName, tbName);
    }
}
