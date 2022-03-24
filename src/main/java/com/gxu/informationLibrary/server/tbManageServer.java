package com.gxu.informationLibrary.server;

import java.util.List;

public interface tbManageServer {
    void createTable(String dbName, String tbName, List tableConfig);
}
