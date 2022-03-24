package com.gxu.informationLibrary.serviceImpl;

import com.gxu.informationLibrary.dao.tableManagerDao;
import com.gxu.informationLibrary.server.tbManageServer;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@Service
public class tbManageImpl implements tbManageServer {
    final tableManagerDao tbManage;

    public tbManageImpl(tableManagerDao tbManage) {
        this.tbManage = tbManage;
    }

    @Override
    @Transient
    public void createTable(String dbName, String tbName, List tableConfig) {
        tbManage.createTable(tableConfig,dbName,tbName);
    }
}
