package com.gxu.informationLibrary.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class column {
    int col_id;
    String db_name;
    String tb_name;
    String col_name;
    String data_type;
    int len;
    int place;
    boolean PK;
    boolean uni;
    boolean not_null;

    public column(JSONObject jsonObject, String db_name, String tb_name) {
        this.db_name =db_name;
        this.tb_name =tb_name;
        this.col_name = jsonObject.getString("col_name");
        this.data_type = jsonObject.getString("data_type");
        this.len = jsonObject.getIntValue("len");
        this.place = jsonObject.getIntValue("place");
        this.PK=jsonObject.getBoolean("PK");
        this.uni = jsonObject.getBoolean("uni");
        this.not_null = jsonObject.getBoolean("not_null");
    }
    public column(String db_name, String tb_name, String col_name, String data_type, int len, int place, boolean PK, boolean uni, boolean not_null) {
        this.db_name = db_name;
        this.tb_name = tb_name;
        this.col_name = col_name;
        this.data_type = data_type;
        this.len = len;
        this.place = place;
        this.PK=PK;
        this.uni = uni;
        this.not_null = not_null;
    }
}
