package com.gxu.informationLibrary.entity;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

@Getter
@Setter
public class column {
    String dbName;
    String tbName;
    String colName;
    String datatype;
    int len;
    int place;
    boolean PK;
    boolean uni;
    boolean not_null;

    public column(JSONObject jsonObject,String dbName,String tbName) {
        this.dbName=dbName;
        this.tbName=tbName;
        this.colName = jsonObject.getString("colName");
        this.datatype = jsonObject.getString("datatype");
        this.len = jsonObject.getInt("length");
        this.place = jsonObject.getInt("place");
        this.PK = jsonObject.getBoolean("PK");
        this.uni = jsonObject.getBoolean("unique");
        this.not_null = jsonObject.getBoolean("not_null");
    }

    public column(String dbName, String tbName, String colName, String datatype, int len, int place, boolean PK, boolean uni, boolean not_null) {
        this.dbName = dbName;
        this.tbName = tbName;
        this.colName = colName;
        this.datatype = datatype;
        this.len = len;
        this.place = place;
        this.PK = PK;
        this.uni = uni;
        this.not_null = not_null;
    }
}
