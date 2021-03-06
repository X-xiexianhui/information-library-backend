package com.gxu.informationLibrary.server;

import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.entity.response;
import com.gxu.informationLibrary.entity.statisticsResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface dataServer {
    response<List<Map<String,String>>>getTableColumn(int form_id);

    response<String>insertData(String parma,HttpServletRequest request);

    response<String>deleteData(String parma);

    response<List<JSONObject>>queryData(String parma, HttpServletRequest request);

    response<String>updateData(String parma);
    response<statisticsResult>statistics(String parma,HttpServletRequest request);
}
