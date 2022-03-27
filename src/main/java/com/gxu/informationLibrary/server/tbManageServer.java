package com.gxu.informationLibrary.server;


import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.entity.table;


import java.util.List;

public interface tbManageServer {
    List<JSONObject> createTable(String Param);
    void deleteTable(String db_name,String tb_name);
    List<table> searchTable(String tb_name);
    void renameTable(String parma);
}
