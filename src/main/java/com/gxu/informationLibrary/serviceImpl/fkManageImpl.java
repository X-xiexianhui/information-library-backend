package com.gxu.informationLibrary.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.dao.fkManagerDao;
import com.gxu.informationLibrary.entity.fk;
import com.gxu.informationLibrary.server.fkManageServer;

import java.util.List;

public class fkManageImpl implements fkManageServer {
    final fkManagerDao fkManage;

    public fkManageImpl(fkManagerDao fkManage) {
        this.fkManage = fkManage;
    }

    public void addFk(String db_name, String tb_name, List<fk> insert) {

    }

    public void deleteFk(String db_name, String tb_name, List<fk> remove) {

    }

    public void updateFk(String db_name, String tb_name, List<fk> update){
        deleteFk(db_name,tb_name,update);
        addFk(db_name,tb_name,update);
    }
    @Override
    public List<fk> alterFk(String param) {
        JSONObject alter= JSON.parseObject(param);
        String db_name=alter.getString("db_name");
        String tb_name=alter.getString("tb_name");
        List<fk>insert=alter.getJSONArray("insert").toJavaList(fk.class);
        List<fk>remove=alter.getJSONArray("remove").toJavaList(fk.class);
        List<fk>update=alter.getJSONArray("update").toJavaList(fk.class);
        addFk(db_name,tb_name,insert);
        deleteFk(db_name,tb_name,remove);
        updateFk(db_name,tb_name,update);
        return getFk();
    }

    @Override
    public List<fk> getFk() {
        return fkManage.getFk();
    }
}
