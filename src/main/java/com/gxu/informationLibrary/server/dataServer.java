package com.gxu.informationLibrary.server;

import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.entity.response;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface dataServer {
    response<List<Map<String,String>>>getTableColumn(int form_id);

    response<List<JSONObject>>getTableData(int form_id);

    response<String>insertData(String parma, HttpServletRequest request);

    List<JSONObject>deleteData(String parma);

    List<JSONObject>queryData(String parma);

    response<List<JSONObject>>updateData(String parma);
}
