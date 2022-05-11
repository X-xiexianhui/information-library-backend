package com.gxu.informationLibrary.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class recycleBin {
    int id;
    int form_id;
    JSONObject data;
    String user;
    String del_time;

    public recycleBin(Integer id, Integer form_id, String data, String user, String del_time) {
        this.id = id;
        this.form_id = form_id;
        this.data = JSON.parseObject(data);
        this.user = user;
        this.del_time = del_time;
    }
}
