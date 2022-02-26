package com.gxu.informationLibrary.dao;

import org.json.JSONObject;

import java.util.List;

public interface tableDao {
    String createTable(List<JSONObject> configList,String tableName);
}
