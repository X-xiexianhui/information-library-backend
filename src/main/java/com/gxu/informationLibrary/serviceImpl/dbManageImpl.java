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
    @Transactional
//    开启事务
    public void createDB(String dbName){
        dbManage.createDbDao(dbName);
        dbManage.insertDbRecordDao(dbName);
    }

    @Override
    @Transactional
//    开启事务
    public void deleteDB(String dbName) {
        dbManage.deleteDbDao(dbName);
        dbManage.deleteDbRecordDao(dbName);
    }

    @Override
    public List<dbInfo> getDB(String dbName) {
        return dbManage.getDbDao(dbName);
    }

    @Override
    public List<dbInfo> getAllDB() {
        return dbManage.getAllDbDao();
    }
    public int getTables(String dbName){
        return dbManage.getTables(dbName);
    }
}
