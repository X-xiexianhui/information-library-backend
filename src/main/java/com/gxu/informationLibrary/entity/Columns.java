package com.gxu.informationLibrary.entity;

import com.alibaba.fastjson.JSONArray;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Columns {
    public List<column>columns=new ArrayList<>();
    public Columns(JSONArray jsonArray, String db_name, String tb_name){
        for (int i=0;i<jsonArray.size();i++) {
            columns.add(new column(jsonArray.getJSONObject(i),db_name,tb_name));
        }
    }
}
