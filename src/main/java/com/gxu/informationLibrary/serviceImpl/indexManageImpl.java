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
        List<index>insert=new indexList(indexJson.getJSONArray("insert")).getIndexes();
        List<index>remove=new indexList(indexJson.getJSONArray("remove")).getIndexes();
        List<index>update=new indexList(indexJson.getJSONArray("update")).getIndexes();
        addIndex(insert);
        deleteIndex(remove);
        updateIndex(update);
        return getIndex(db_name,tb_name);
    }

    private void addIndex(List<index>insert) {
        if (insert.size()==0)return;
        indexManage.addIndex(insert);
    }
    private void deleteIndex(@NotNull List<index>remove){
        if (remove.size()==0)return;
        for (index i:remove) {

        }
    }
    private void updateIndex(List<index>update){
        deleteIndex(update);
        addIndex(update);
    }
    private List<index> getIndex(String db_name,String tb_name){
        return indexManage.getIndex(db_name,tb_name);
    }
    public List<String>getColumns(String db_name,String tb_name){
        return indexManage.getColumns(db_name,tb_name);
    }
}
