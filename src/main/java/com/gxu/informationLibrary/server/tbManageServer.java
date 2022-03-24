package com.gxu.informationLibrary.server;
import org.json.JSONArray;

public interface tbManageServer {
    void createTable(String dbName, String tbName, JSONArray tableConfig);
}
