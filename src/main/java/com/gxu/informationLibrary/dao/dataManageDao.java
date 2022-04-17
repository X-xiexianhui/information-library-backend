package com.gxu.informationLibrary.dao;

import netscape.javascript.JSObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface dataManageDao {
    void insertData();

    void updateData();

    void deleteData();

    List<JSObject>queryData();
}
