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
public class fkManageImpl implements fkManageServer {
    private final fkManagerDao fkManager;

    public fkManageImpl(fkManagerDao fkManager) {
        this.fkManager = fkManager;
    }

    public List<String>getRefTable(){
        return fkManager.getRefTable();
    }
    public List<String>getRefColumn(String ref_table){
       return fkManager.getRefColumn(ref_table);
    }
    public List<String>getFkColumn(String db_nam,String tb_name){
        return fkManager.getFkColumn(db_nam,tb_name);
    }
    @Override
    @Transactional
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
    public void addFk(String db_name, String tb_name,List<fk> insert) {
        if (insert.size()==0)return;
        for (fk in: insert) {
            in.setFk_name(getFkName(in));
            String[]ref_info=in.getRef_table().split("\\.");
            fkManager.createFK(db_name,tb_name,in.getFk_name(),in.getFk_column(),ref_info[0],ref_info[1],in.getRef_column());
            int fk_table=fkManager.queryTable(db_name,tb_name);
            int ref_table=fkManager.queryTable(ref_info[0],ref_info[1]);
            fkManager.insertFkInfo(fk_table,in.getFk_column(),in.getFk_name(),ref_table,in.getRef_column());
        }
    }

    public void deleteFk(String db_name, String tb_name,List<fk> remove) {
        if (remove.size()==0)return;
        for (fk re: remove) {
            fkManager.deleteFk(db_name,tb_name,re.getFk_name());
            int fk_table=fkManager.queryTable(db_name,tb_name);
            fkManager.deleteFkInfo(fk_table,re.getFk_column());
        }
    }

    public void updateFk(String db_name, String tb_name, List<fk> update){
        deleteFk(db_name,tb_name,update);
        addFk(db_name,tb_name,update);
    }
    @Override
    public List<fk> getFk(String db_name,String tb_name) {
        return fkManager.getFk(db_name,tb_name);
    }
    private @NotNull String getFkName(fk fkInfo){
        return fkInfo.getFk_column() +
                "_" +
                fkInfo.getRef_column()+"_fk";
    }
}
