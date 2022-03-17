package com.gxu.informationLibrary.server;

import org.json.JSONObject;

public interface dbManager {
    void createDB(JSONObject config);
    void deleteDB(String dbName);
    void searchDB(String dbName);
    void searchAllDB();
    void alterDB(JSONObject alterConfig);
}
