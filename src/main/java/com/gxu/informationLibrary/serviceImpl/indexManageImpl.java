package com.gxu.informationLibrary.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.dao.indexManageDao;
import com.gxu.informationLibrary.entity.index;
import com.gxu.informationLibrary.entity.indexList;
import com.gxu.informationLibrary.server.indexManage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class indexManageImpl implements indexManage {
    final indexManageDao indexManage;

    public indexManageImpl(indexManageDao indexManage) {
        this.indexManage = indexManage;
    }

    @Override
    public List<index> alterIndex(String Parma) {
        JSONObject indexJson = JSON.parseObject(Parma);
        List<index>insert=new indexList(indexJson.getJSONArray("insert")).getIndexes();
        List<index>remove=new indexList(indexJson.getJSONArray("remove")).getIndexes();
        List<index>update=new indexList(indexJson.getJSONArray("update")).getIndexes();
        addIndex(insert);
        deleteIndex(remove);
        updateIndex(update);
        return getIndex();
    }

    private void addIndex(List<index>insert) {

    }
    private void deleteIndex(List<index>remove){

    }
    private void updateIndex(List<index>update){
        deleteIndex(update);
        addIndex(update);
    }
    private List<index> getIndex(){
        return null;
    }
    public List<String>getColumns(String db_name,String tb_name){
        return indexManage.getColumns(db_name,tb_name);
    }
}
