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

    public indexList(@NotNull JSONArray indexArray) {
        for (int i = 0; i < indexArray.size(); i++) {
            JSONObject object=indexArray.getJSONObject(i);
            String index_name= object.getString("index_name");
            List<String>fields= object.getJSONArray("fields").toJavaList(String.class);
            boolean uni=object.getBoolean("uni");
            indexes.add(new index(index_name,fields,uni));
        }
    }
}
