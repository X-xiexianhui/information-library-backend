package com.gxu.informationLibrary.server;

import com.gxu.informationLibrary.entity.dbInfo;

import java.util.List;

public interface dbManageServer {
    void createDB(String dbName);
    void deleteDB(String dbName);
    List<dbInfo> getDB(String dbName);
    List<dbInfo> getAllDB();
}
