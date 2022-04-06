package com.gxu.informationLibrary.entity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class alterColumns {
    public List<alterColumn> alterColumns = new ArrayList<>();

    public alterColumns(JSONArray jsonArray,String db_name,String tb_name) {
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            int col_id = jsonObject.getIntValue("col_id");
            String col_name = jsonObject.getString("col_name");
            if (col_name.equals("PK") || col_name.equals("not_null") || col_name.equals("uni")) {
                boolean new_value = jsonObject.getBooleanValue("new_value");
                alterColumns.add(new alterColumn<>(col_id,db_name, tb_name, col_name, new_value));
            } else {
                String new_value = jsonObject.getString("new_value");
                alterColumns.add(new alterColumn<>(col_id,db_name, tb_name, col_name, new_value));
            }
        }
    }
}
