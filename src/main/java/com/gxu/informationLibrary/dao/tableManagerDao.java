package com.gxu.informationLibrary.dao;

import com.gxu.informationLibrary.entity.column;
import com.gxu.informationLibrary.entity.table;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface tableManagerDao {
    void createTable(@Param("column") List column,@Param("pks") List pks, @Param("dbName") String dbName, @Param("tbName") String tbName);
    void deleteTable(@Param("dbName")String dbName,@Param("tbName")String tbName);
    List<table>searchTables(@Param("tbName")String tbName);
    void alterTable(@Param("column") List column, @Param("pks") List pks, @Param("dbName") String dbName, @Param("tbName") String tbName);
    List<column>getColumnList(@Param("dbName")String dbName,@Param("tbName")String tbName);
}