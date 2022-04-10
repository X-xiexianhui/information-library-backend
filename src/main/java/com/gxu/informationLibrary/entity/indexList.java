package com.gxu.informationLibrary.entity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.gxu.informationLibrary.util.utils.getString;


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
            if (!isAdd){
                index_name=object.getString("index_name");
            }else {
                index_name=getIndexName(fields,uni);
            }
            indexes.add(new index(index_name,fields,uni));
        }
    }
    private @NotNull String getIndexName(List<String>fields, boolean uni){
        return getString(fields, uni);
    }
}
