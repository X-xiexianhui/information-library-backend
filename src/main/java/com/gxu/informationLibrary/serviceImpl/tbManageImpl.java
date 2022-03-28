package com.gxu.informationLibrary.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.gxu.informationLibrary.dao.tableManagerDao;
import com.gxu.informationLibrary.entity.Columns;
import com.gxu.informationLibrary.entity.column;
import com.gxu.informationLibrary.entity.table;
import com.gxu.informationLibrary.server.tbManageServer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class tbManageImpl implements tbManageServer {
    final tableManagerDao tbManage;

    private boolean isAlterPK = false;

    public tbManageImpl(tableManagerDao tbManage) {
        this.tbManage = tbManage;
    }

    @Override
    public List<JSONObject> createTable(String Param) {
        JSONObject jsonParam = JSONObject.parseObject(Param, Feature.OrderedField);
        String db_name = jsonParam.getString("db_name");
        String tb_name = jsonParam.getString("tb_name");
        List<column> columns = new Columns(jsonParam.getJSONArray("column"), db_name, tb_name).getColumns();
        List<String> pks = new ArrayList<>();
        for (column c : columns) {
            if (c.isPK()) {
                pks.add(c.getCol_name());
            }
        }
        tbManage.createTable(columns, pks, db_name, tb_name);
        return tbManage.getColumn(db_name, tb_name);
    }

    @Override
    public void deleteTable(String db_name, String tb_name) {
        tbManage.deleteTable(db_name, tb_name);
    }

    @Override
    public List<table> searchTable(String tb_name) {
        return tbManage.searchTable(tb_name);
    }

    @Override
    public void renameTable(String parma) {
        JSONObject object = JSON.parseObject(parma);
        tbManage.renameTable(object.getString("db_name"), object.getString("tb_name"), object.getString("new_name"));
    }

    @Override
    public List<JSONObject> alterTable(String Param) {
        addColumn();
        dropColumn();
        alterColumn();
        if (isAlterPK) {
            alterPK();
        }
        return tbManage.getColumn("","");
    }
//    新增一列
    private void addColumn() {
        tbManage.addColumn();
        tbManage.addUnique();
        tbManage.setNotNull();
        setIsAlterPK();
    }
// 删除一列
    private void dropColumn() {
        tbManage.dropColumn();
    }
// 修改一列
    private void alterColumn() {
        changeColumn();
        alterUnique();
        setNotNull();
        setIsAlterPK();
    }
// 修改列名或者数据类型
    private void changeColumn() {
        tbManage.changeColumn();
    }
// 修改唯一性约束
    private void alterUnique() {
        tbManage.dropUnique();
        tbManage.addUnique();
    }

    private void setNotNull(){
        tbManage.setNotNull();
    }

    private void alterPK() {
        tbManage.dropPK();
        tbManage.addPK();
    }
    private void setIsAlterPK(){
        if (!isAlterPK){
            isAlterPK=true;
        }
        tbManage.setColumnInfo("PK",1);
    }
}
