package com.gxu.informationLibrary.dao;

import com.gxu.informationLibrary.entity.column;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface tableManagerDao {
    void createTable(@Param("column") List column,@Param("pks") List pks, @Param("dbName") String dbName, @Param("tbName") String tbName);
    List<String>getColumns(@Param("dbName")String dbName,@Param("tbName")String tbName);
    void setTables(@Param("dbName") String dbName);
    void setTbInfo(@Param("dbName")String dbName,@Param("tbName")String tbName);
    void setColumn(@Param("list")List columns,@Param("tbName")String tbName,@Param("dbName")String dbName);
}