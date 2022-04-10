package com.gxu.informationLibrary.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.dao.indexManageDao;
import com.gxu.informationLibrary.entity.index;
import com.gxu.informationLibrary.entity.indexList;
import com.gxu.informationLibrary.server.indexManage;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class indexManageImpl implements indexManage {
    final indexManageDao indexManage;

    public indexManageImpl(indexManageDao indexManage) {
        this.indexManage = indexManage;
    }

    @Override
    public List<index> alterIndex(String Parma) {
        JSONObject indexJson = JSON.parseObject(Parma);
        String db_name=indexJson.getString("db_name");
        String tb_name=indexJson.getString("tb_name");
        List<index>insert=new indexList(indexJson.getJSONArray("insert"),true).getIndexes();
        List<index>remove=new indexList(indexJson.getJSONArray("remove"),true).getIndexes();
        List<index>update=new indexList(indexJson.getJSONArray("update"),true).getIndexes();
        addIndex(insert,db_name,tb_name);
        deleteIndex(remove,db_name,tb_name);
        updateIndex(update,db_name,tb_name);
        return getIndex(db_name,tb_name);
    }

    private void addIndex(List<index>insert,String db_name,String tb_name) {
        if (insert.size()==0)return;
        indexManage.addIndex(insert,db_name,tb_name);
    }
    private void deleteIndex(@NotNull List<index>remove,String db_name,String tb_name){
        if (remove.size()==0)return;
        for (index i:remove) {
            indexManage.dropIndex(db_name,tb_name,i.getIndex_name());
        }
    }
    private void updateIndex(List<index>update,String db_name,String tb_name){
        deleteIndex(update,db_name,tb_name);
        addIndex(update,db_name,tb_name);
    }
    public List<index> getIndex(String db_name,String tb_name){
        return indexManage.getIndex(db_name,tb_name);
    }
    public List<String>getColumns(String db_name,String tb_name){
        return indexManage.getColumns(db_name,tb_name);
    }
}
