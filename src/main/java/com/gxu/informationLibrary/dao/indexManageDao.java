package com.gxu.informationLibrary.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface indexManageDao {
    List<String> getColumns(@Param("dbName")String dbName, @Param("tbName")String tbName);
}
