package com.gxu.informationLibrary.dao;

import com.gxu.informationLibrary.entity.fk;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface fkManagerDao {
    void addFk(@Param("db_name") String db_name,@Param("tb_name") String tb_name,@Param("fk_name") String fk_name,@Param("fk_column") String fk_column,@Param("ref_table") String ref_table,@Param("ref_column") String ref_column);
    void deleteFk();
    void insertFkInfo();
    void deleteFkInfo();
    List<String>getRefTable();
    List<String>getRefColumn(@Param("ref_table") String ref_table);
    List<fk>getFk();
}
