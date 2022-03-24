package com.gxu.informationLibrary.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.json.JSONArray;

import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface tableManagerDao {
    void createTable(@Param("column") JSONArray column,@Param("dbName") String dbName, @Param("tbName") String tbName);
}