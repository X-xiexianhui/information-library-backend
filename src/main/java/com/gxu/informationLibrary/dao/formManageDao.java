package com.gxu.informationLibrary.dao;

import com.gxu.informationLibrary.entity.column;
import com.gxu.informationLibrary.entity.formStruct;
import com.gxu.informationLibrary.entity.formTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface formManageDao {
    List<formTable>query(@Param("tb_name")String tb_name);

    void renameForm(@Param("old_name") String old_name,@Param("new_name") String new_name,@Param("form_id") int form_id);

    void editForm(@Param("formStructList") List<formStruct>formStructList);

    List<formStruct> getFormStruct(@Param("form_id") int form_id);

    List<Map<String, Object>>getFormSelect();

    void insertFormInfo(@Param("db_name") String db_name,@Param("tb_name") String tb_name);

    void insertFormStruct(@Param("column")List<column>columns,@Param("db_name") String db_name,@Param("tb_name") String tb_name);

    int queryFormId(@Param("form_name")String form_name);

    List<Integer>getFormList();
}
