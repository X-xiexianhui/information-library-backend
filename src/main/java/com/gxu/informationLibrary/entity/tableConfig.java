package com.gxu.informationLibrary.entity;


import org.json.JSONArray;
import org.json.JSONObject;


import java.util.List;

/**
 * 数据库表参数实体，用于创建数据库
 */
public class tableConfig {
    private List<JSONObject> configList;

    public tableConfig(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            this.configList.add(array.getJSONObject(i));
        }
    }

    public List<JSONObject> getConfigList() {
        return configList;
    }

    public void setConfigList(List<JSONObject> configList) {
        this.configList = configList;
    }
}
