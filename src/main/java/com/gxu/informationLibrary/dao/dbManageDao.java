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
    void insertDbRecordDao(@Param("dbName") String dbName);
    void deleteDbDao(@Param("dbName") String dbName);
    void deleteDbRecordDao(@Param("dbName") String dbName);
    List<dbInfo> getDbDao(@Param("dbName") String dbName);
    List<dbInfo> getAllDbDao();
}