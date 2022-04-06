package com.gxu.informationLibrary.dao;


import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.entity.column;
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

    void addColumn(@Param("insert") List<column> insert);

    void dropColumn(@Param("db_name") String db_name, @Param("tb_name") String tb_name, @Param("col_name") String col_name);

    //    修改列名或者类型
    void changeColumn(@Param("db_name")String db_name,@Param("tb_name") String tb_name,@Param("col_name") String col_name,@Param("new_column") String new_column,@Param("data_type") String data_type,@Param("len") int len,@Param("place") int place);

    void dropPK(@Param("db_name")String db_name,@Param("tb_name") String tb_name);

    void addPK(@Param("db_name") String db_name,@Param("tb_name") String tb_name,@Param("pks") List<String>pks);

    void setNotNull(@Param("db_name")String db_name,@Param("tb_name") String tb_name,@Param("col_name") String col_name,@Param("data_type") String data_type,@Param("len") int len,@Param("place") int place,@Param("not_null")boolean not_null);

    void addUnique(@Param("db_name") String db_name,@Param("tb_name") String tb_name,@Param("col_name") String col_name);

    void dropUnique(@Param("db_name") String db_name,@Param("tb_name") String tb_name,@Param("key_name") String key_name);

    JSONObject showKeys(@Param("db_name") String db_name, @Param("tb_name") String tb_name, @Param("col_name") String col_name);

    <T> List<String> query(@Param("query_col")String query_col,@Param("query_name")String query_name,@Param("query_value")T query_value);
    <T>int queryInt(@Param("query_col")String query_col,@Param("query_name")String query_name,@Param("query_value")T query_value);
    <T> void setColumnInfo(@Param("col_name") String col_name, @Param("new_value") T new_value, @Param("col_id") int col_id);
    List<String>getPKs(@Param("db_name")String db_name,@Param("tb_name") String tb_name);
}