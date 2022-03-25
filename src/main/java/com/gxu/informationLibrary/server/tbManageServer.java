package com.gxu.informationLibrary.server;


import java.util.List;

public interface tbManageServer {
    void createTable(String Param);
    List<String> getColumns(String dbName, String tbName);
}
