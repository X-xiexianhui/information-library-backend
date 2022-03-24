package com.gxu.informationLibrary.entity;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Columns {
    public List<column>columns=new ArrayList<>();
    public Columns(JSONArray jsonArray,String dbName,String tbName){
        for (int i=0;i<jsonArray.length();i++) {
            columns.add(new column(jsonArray.getJSONObject(i),dbName,tbName));
        }
    }
}
