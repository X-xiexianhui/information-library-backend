package com.gxu.informationLibrary.server;


import com.gxu.informationLibrary.entity.column;

import java.util.List;

public interface tbManageServer {
    List<column> createTable(String Param);
    void deleteTable(String dbName,String tbName);
}
