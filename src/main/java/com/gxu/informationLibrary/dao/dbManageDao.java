package com.gxu.informationLibrary.dao;

import com.gxu.informationLibrary.entity.dbInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface dbManageDao {
    void createDbDao(@Param("dbName") String dbName);
    void deleteDbDao(@Param("dbName") String dbName);
    List<dbInfo> searchDbDao(@Param("dbName") String dbName);
    int getTables(@Param("dbName") String dbName);
}