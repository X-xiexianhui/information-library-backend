package com.gxu.informationLibrary.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.dao.fkManagerDao;
import com.gxu.informationLibrary.entity.fk;
import com.gxu.informationLibrary.server.fkManageServer;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class fkManageImpl implements fkManageServer {
    final fkManagerDao fkManage;

    public fkManageImpl(fkManagerDao fkManage) {
        this.fkManage = fkManage;
    }
    public List<String>getRefTable(){
        return fkManage.getRefTable();
    }
    public List<String>getRefColumn(String ref_table){
       return fkManage.getRefColumn(ref_table);
    }
    public List<String>getFkColumn(String db_nam,String tb_name){
        return fkManage.getFkColumn(db_nam,tb_name);
    }
    public void addFk(String db_name, String tb_name,List<fk> insert) {
        if (insert.size()==0)return;
        for (fk in: insert) {
            in.setFk_name(getFkName(in));
            fkManage.addFk(db_name,tb_name,in.getFk_name(),in.getFk_column(),in.getRef_table(),in.getRef_column());
            int fk_table=fkManage.queryTable(db_name+"."+tb_name);
            int ref_table=fkManage.queryTable(in.getRef_table());
            fkManage.insertFkInfo(fk_table,in.getFk_column(),in.getFk_name(),ref_table,in.getRef_column());
        }
    }

    public void deleteFk(String db_name, String tb_name,List<fk> remove) {
        if (remove.size()==0)return;
        for (fk re: remove) {
            fkManage.deleteFk(db_name,tb_name,re.getFk_name());
            int fk_table=fkManage.queryTable(db_name+"."+tb_name);
            fkManage.deleteFkInfo(fk_table,re.getFk_column());
        }
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
        return getFk(db_name,tb_name);
    }

    @Override
    public List<fk> getFk(String db_name,String tb_name) {
        return fkManage.getFk(db_name,tb_name);
    }
    private @NotNull String getFkName(fk fkInfo){
        return fkInfo.getFk_column() +
                "_" +
                fkInfo.getRef_column();
    }
}
