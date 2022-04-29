package com.gxu.informationLibrary.server;

import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.entity.response;

import java.util.List;
import java.util.Map;

public interface dataServer {
    response<List<Map<String,String>>>getTableColumn(int form_id);

    response<List<JSONObject>>getTableData(int form_id);

    List<JSONObject>insertData(String parma);

    List<JSONObject>deleteData(String parma);

    List<JSONObject>queryData(String parma);

    List<JSONObject>updateData(String parma);
}
