package com.gxu.informationLibrary.server;

import com.gxu.informationLibrary.entity.dbInfo;

import java.util.List;

public interface dbManageServer {
    void createDB(String db_name);
    void deleteDB(String db_name);
    List<dbInfo> searchDB(String db_name);
}
