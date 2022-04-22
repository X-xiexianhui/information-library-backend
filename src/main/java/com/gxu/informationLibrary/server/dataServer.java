package com.gxu.informationLibrary.server;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface dataServer {
    List<JSONObject>insertData(String parma);

    List<JSONObject>deleteData(String record_id);

    List<JSONObject>queryData(String parma);

    List<JSONObject>updateData(String parma);
}
