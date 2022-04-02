package com.gxu.informationLibrary.dao;


import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.entity.table;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface tableManagerDao {
    void createTable(@Param("column") List column, @Param("pks") List pks, @Param("db_name") String db_name, @Param("tb_name") String tb_name);

    void deleteTable(@Param("db_name") String db_name, @Param("tb_name") String tb_name);

    List<table> searchTable(@Param("tb_name") String tb_name);

    void renameTable(@Param("db_name") String db_name, @Param("tb_name") String tb_name, @Param("new_name") String new_name);

    List<JSONObject> getColumn(@Param("db_name") String db_name, @Param("tb_name") String tb_name);

    void addColumn();

    void dropColumn(@Param("db_name")String db_name,@Param("tb_name")String tb_name,@Param("col_name")String col_name);

    //    修改列名或者类型
    void changeColumn();

    void dropPK();

    void addPK();

    void setNotNull();

    void addUnique();

    void dropUnique();

    JSONObject showKeys(@Param("db_name") String db_name,@Param("tb_name") String tb_name,@Param("col_name") String col_name);

    <T> List<String> query(@Param("col_name") String col_name, @Param("query_col") String query_col, @Param("query_value") T query_value);
    <T>void setColumnInfo(@Param("col_name") String col_name,@Param("new_value") T new_value,@Param("col_id") int col_id);
}