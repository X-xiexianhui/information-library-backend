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

    public alterColumns(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            int col_id = jsonObject.getIntValue("col_id");
            String db_name = jsonObject.getString("db_name");
            String tb_name = jsonObject.getString("tb_name");
            String col_name = jsonObject.getString("col_name");
            if (Objects.equals(col_name, "PK") || Objects.equals(col_name, "not_null") || Objects.equals(col_name, "nui")) {
                int new_value = jsonObject.getIntValue("new_value");
                alterColumns.add(new alterColumn<>(col_id,db_name, tb_name, col_name, new_value));
            } else {
                String new_value = jsonObject.getString("new_value");
                alterColumns.add(new alterColumn<>(col_id,db_name, tb_name, col_name, new_value));
            }
        }
    }
}
