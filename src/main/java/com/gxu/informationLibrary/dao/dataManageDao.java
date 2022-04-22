package com.gxu.informationLibrary.dao;

import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.entity.editEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface dataManageDao {
    void insertData(@Param("db_name") String db_name,@Param("tb_name") String tb_name,@Param("col_name") List<String>col_name,@Param("value") List<Object>value);

    void updateData(String db_name,String tb_name,List<editEntity>updates);

    void deleteData();

    List<JSONObject>queryData(String db_name, String tb_name, List<editEntity>columns, boolean onlyAuth);
}
