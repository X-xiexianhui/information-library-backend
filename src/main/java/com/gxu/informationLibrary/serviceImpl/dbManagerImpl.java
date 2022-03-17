package com.gxu.informationLibrary.serviceImpl;

import com.gxu.informationLibrary.dao.dbDao;
import com.gxu.informationLibrary.server.dbManager;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class dbManagerImpl implements dbManager {
    @Autowired
    private dbDao DB;

    @Override
    public void createDB(JSONObject config) {
        DB.createDB(config);
    }

    @Override
    public void deleteDB(String dbName) {
        DB.deleteDB(dbName);
    }

    @Override
    public void searchDB(String dbName) {
        DB.searchDB(dbName);
    }

    @Override
    public void searchAllDB() {
        DB.searchAllDB();
    }

    @Override
    public void alterDB(JSONObject alterConfig) {
        DB.alterDB(alterConfig);
    }
}
