package com.gxu.informationLibrary.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;

@Mapper
public interface dbDao {
    void createDB(@Param("config") JSONObject config);
    void deleteDB(String dbName);
    void searchDB(String dbName);
    void searchAllDB();
    void alterDB(JSONObject alterConfig);
}
