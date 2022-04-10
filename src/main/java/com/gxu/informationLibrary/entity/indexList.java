package com.gxu.informationLibrary.entity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class indexList {
    List<index>indexes=new ArrayList<>();

    public indexList(@NotNull JSONArray indexArray,boolean isAdd) {
        for (int i = 0; i < indexArray.size(); i++) {
            JSONObject object=indexArray.getJSONObject(i);
            List<String>fields= object.getJSONArray("fields").toJavaList(String.class);
            boolean uni= object.getBoolean("uni");
            String index_name;
            if (isAdd){
                index_name=object.getString("index_name");
            }else {
                index_name=getIndexName(fields,uni);
            }
            indexes.add(new index(index_name,fields,uni));
        }
    }
    private String getIndexName(List<String>fields,boolean uni){
        StringBuilder index_name= new StringBuilder();
        for (String str:fields) {
            index_name.append(str);
            index_name.append("_");
        }
        if (uni){
            index_name.append("uni_index");
        }else {
            index_name.append("index");
        }
        return index_name.toString();
    }
}
