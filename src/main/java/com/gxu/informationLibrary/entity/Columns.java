package com.gxu.informationLibrary.entity;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Columns {
    public List<Object>columns=new ArrayList<>();
    public Columns(JSONArray jsonArray){
        for (int i=0;i<jsonArray.length();i++) {
            columns.add(new column(jsonArray.getJSONObject(i)));
        }
    }
}
