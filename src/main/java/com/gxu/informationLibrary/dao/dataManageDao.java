package com.gxu.informationLibrary.dao;

import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.entity.editEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface dataManageDao {
    void insertData(@Param("db_name") String db_name,@Param("tb_name") String tb_name,List<editEntity>columns);

    void updateData(String db_name,String tb_name,List<editEntity>updates);

    void deleteData(String db_name,String tb_name,String record_id);

    List<JSONObject>queryData(String db_name, String tb_name, List<editEntity>columns, @Param("onlyAuth") boolean onlyAuth,@Param("user_id") String user_id);

    List<Map<String,String>>getTableColumn(@Param("form_id") int form_id);

    Map<String,String> getTableByFormId(@Param("form_id") int form_id);

    List<JSONObject>getData(String db_name,String tb_name,boolean onlyAuth);
}
