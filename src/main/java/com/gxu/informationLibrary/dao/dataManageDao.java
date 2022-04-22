package com.gxu.informationLibrary.dao;

import netscape.javascript.JSObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface dataManageDao {
    void insertData(@Param("db_name") String db_name,@Param("tb_name") String tb_name,@Param("col_name") List<String>col_name,@Param("value") List<Object>value);

    void updateData();

    void deleteData();

    List<JSObject>queryData(String db_name,String tb_name,List<String>columns,boolean onlyAuth);
}
