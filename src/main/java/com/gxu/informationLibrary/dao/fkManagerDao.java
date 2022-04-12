package com.gxu.informationLibrary.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface fkManagerDao {
    void addFk();
    void deleteFk();
    void insertFkInfo();
    void deleteFkInfo();
    List<String>getRefTable();
    List<String>getRefColumn(@Param("ref_table") String ref_table);
}
