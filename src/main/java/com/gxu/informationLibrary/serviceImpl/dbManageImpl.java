package com.gxu.informationLibrary.serviceImpl;

import com.gxu.informationLibrary.dao.dbManageDao;
import com.gxu.informationLibrary.entity.dbInfo;
import com.gxu.informationLibrary.server.dbManageServer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class dbManageImpl implements dbManageServer {
    final dbManageDao dbManage;

    public dbManageImpl(dbManageDao dbManage) {
        this.dbManage = dbManage;
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
//    开启事务
//    创建数据库
    public void createDB(String dbName) {
        dbManage.createDb(dbName);
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
//    开启事务
//    删除数据库
    public void deleteDB(String dbName) {
        dbManage.deleteDb(dbName);
    }

    @Override
    public List<dbInfo> searchDB(String dbName) {
        return dbManage.searchDb(dbName);
    }

    public int getTables(String dbName) {
        return dbManage.getTables(dbName);
    }
}
