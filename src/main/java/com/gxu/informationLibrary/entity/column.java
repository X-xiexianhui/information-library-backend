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
    int length;
    int place;
    boolean PK;
    boolean unique;
    boolean not_null;

    public column(JSONObject jsonObject) {
        this.colName = jsonObject.getString("colName");
        this.datatype = jsonObject.getString("datatype");
        this.length = jsonObject.getInt("length");
        this.place = jsonObject.getInt("place");
        this.PK = jsonObject.getBoolean("PK");
        this.unique = jsonObject.getBoolean("unique");
        this.not_null = jsonObject.getBoolean("not_null");
    }
}
