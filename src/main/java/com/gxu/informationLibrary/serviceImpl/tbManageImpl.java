package com.gxu.informationLibrary.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.gxu.informationLibrary.dao.tableManagerDao;
import com.gxu.informationLibrary.entity.*;
import com.gxu.informationLibrary.server.tbManageServer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
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
    public void deleteTable(String db_name, String tb_name) throws Exception {
        if (tbManage.count(db_name,tb_name)>0){
            throw new Exception("数据库表非空，不允许删除");
        }
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
        JSONObject json = JSON.parseObject(Param);
        String db_name = json.getString("db_name");
        String tb_name = json.getString("tb_name");
        List<column> insert = new Columns(json.getJSONArray("insert"), db_name, tb_name).getColumns();
        List<column> remove = new Columns(json.getJSONArray("remove"), db_name, tb_name).getColumns();
        List<alterColumn<Object>> update = new alterColumns(json.getJSONArray("update"),db_name,tb_name).getAlterColumns();
        addColumn(insert);
        dropColumn(remove);
        alterColumn(update);
        if (isAlterPK) {
            alterPK(db_name, tb_name);
            isAlterPK = false;
        }
        return tbManage.getColumn(db_name, tb_name);
    }

    public List<JSONObject> getColumn(String db_name, String tb_name) {
        return tbManage.getColumn(db_name, tb_name);
    }

    //    新增一列
    private void addColumn(List<column> insert) {
        if (insert.size() == 0) return;
        tbManage.addColumn(insert);
        for (column c : insert) {
            if (c.isPK()) {
                isAlterPK = true;
                break;
            }
        }
    }

    // 删除一列
    private void dropColumn(List<column> remove) {
        if (remove.size() == 0) return;
        for (column r : remove) {
            tbManage.dropColumn(r.getDb_name(), r.getTb_name(), r.getCol_name());
        }
    }

    // 修改一列
    private void alterColumn(List<alterColumn<Object>> alterColumn) {
        if (alterColumn.size() == 0) return;
        for (alterColumn<Object> alter : alterColumn) {
            switch (alter.getEdit_field()) {
                case "PK":
                    setIsAlterPK(alter.getCol_id(), (Boolean) alter.getNew_Value());
                    break;
                case "not_null":
                    setNotNull(alter.getDb_name(), alter.getTb_name(), alter.getCol_id(), (Boolean) alter.getNew_Value());
                    break;
                case "uni":
                    alterUnique(alter.getDb_name(), alter.getTb_name(), alter.getCol_id(), (Boolean) alter.getNew_Value());
                    break;
                default:
                    changeColumn(alter);
                    break;
            }
        }
    }

    // 修改列名或者数据类型
    private void changeColumn(alterColumn<Object> alter) {
        String db_name = alter.getDb_name();
        String tb_name = alter.getTb_name();
        int col_id = alter.getCol_id();
        String col_name=tbManage.query("col_name","col_id",col_id).get(0);
        String data_type =tbManage.query("data_type","col_id",col_id).get(0);
        int len =tbManage.queryInt("len","col_id",col_id);
        int place =tbManage.queryInt("place","col_id",col_id);
//        修改列名
        switch (alter.getEdit_field()) {
            case "col_name":
                tbManage.changeColumn(db_name, tb_name, col_name, (String) alter.getNew_Value(), data_type, len, place);
                tbManage.setColumnInfo("col_name", alter.getNew_Value(), col_id);
//            修改数据类型
                break;
            case "data_type":
                tbManage.changeColumn(db_name, tb_name, col_name, col_name, (String) alter.getNew_Value(), len, place);
                tbManage.setColumnInfo("data_type", alter.getNew_Value(), col_id);
//            修改长度
                break;
            case "len":
                tbManage.changeColumn(db_name, tb_name, col_name, col_name, data_type, (Integer) alter.getNew_Value(), place);
                tbManage.setColumnInfo("len", alter.getNew_Value(), col_id);
//            修改小数位数
                break;
            default:
                tbManage.changeColumn(db_name, tb_name, col_name, col_name, data_type, len, (Integer) alter.getNew_Value());
                tbManage.setColumnInfo("place", alter.getNew_Value(), col_id);
                break;
        }
    }

    // 修改唯一性约束
    private void alterUnique(String db_name, String tb_name, int col_id, boolean uni) {
        String col_name=tbManage.query("col_name","col_id",col_id).get(0);
        JSONObject json = tbManage.showKeys(db_name, tb_name, col_name);
        if (uni){
            tbManage.addUnique(db_name,tb_name,col_name);
        }else {
            String key = json.getString("Key_name");
            tbManage.dropUnique(db_name,tb_name,key);
        }
    }

    private void setNotNull(String db_name, String tb_name, int col_id, boolean not_null) {
        String col_name=tbManage.query("col_name","col_id",col_id).get(0);
        String data_type =tbManage.query("data_type","col_id",col_id).get(0);
        int len =tbManage.queryInt("len","col_id",col_id);
        int place =tbManage.queryInt("place","col_id",col_id);
        tbManage.setNotNull(db_name, tb_name, col_name,data_type,len,place,not_null);
    }

    private void alterPK(String db_name, String tb_name) {
        int hasPK = tbManage.getPrimaryKey(db_name,tb_name);
        if (hasPK>0){
            tbManage.dropPK(db_name, tb_name);
        }
        List<String> pks = tbManage.getPKs(db_name, tb_name);
        if (pks.size() == 0) return;
        tbManage.addPK(db_name,tb_name,pks);
    }

    private void setIsAlterPK(int col_id, boolean isPK) {
        if (!isAlterPK) {
            isAlterPK = true;
        }
        tbManage.setColumnInfo("PK", isPK, col_id);
    }
}
