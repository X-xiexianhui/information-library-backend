package com.gxu.informationLibrary.server;

import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;

import java.util.List;

public interface dataServer {
    List<JSObject>insertData(String parma);

    List<JSObject>deleteData(String record_id);

    List<JSONObject>queryData(String parma);

    List<JSONObject>updateData(String parma);
}
