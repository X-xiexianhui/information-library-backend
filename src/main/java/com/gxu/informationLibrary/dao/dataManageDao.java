package com.gxu.informationLibrary.dao;

import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.entity.editEntity;
import com.gxu.informationLibrary.entity.statisticsResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface dataManageDao {
    void insertData(@Param("db_name") String db_name, @Param("tb_name") String tb_name, List<editEntity> columns);

    void updateData(String db_name, String tb_name, int record_id, List<editEntity> updates);

    void deleteData(@Param("db_name") String db_name, @Param("tb_name") String tb_name, @Param("record_id") int record_id);

    List<JSONObject> queryData(@Param("db_name") String db_name, @Param("tb_name") String tb_name,
                               @Param("columns") List<editEntity> columns,
                               @Param("onlyAuth") boolean onlyAuth, @Param("user_id") String user_id);

    List<Map<String, String>> getTableColumn(@Param("form_id") int form_id);

    Map<String, String> getTableByFormId(@Param("form_id") int form_id);

    List<Map<String,Object>>statistics(@Param("option") String option, @Param("db_name") String db_name,
                                @Param("tb_name") String tb_name, @Param("field") String field,
                                @Param("group_field") String group_field, @Param("onlyUser") boolean onlyUser,
                                @Param("user_id") String user_id);

    List<JSONObject> getDumpList(@Param("dump_time") String dump_time);

    void removeToRecycle(@Param("form_id") int from_id,@Param("data") String data);

    JSONObject queryDataById(@Param("record_id") int record_id);

    List<JSONObject>getRecycleData(String form_name);
}
