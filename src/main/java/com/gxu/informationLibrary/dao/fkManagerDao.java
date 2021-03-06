package com.gxu.informationLibrary.dao;

import com.gxu.informationLibrary.entity.fk;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface fkManagerDao {
    void createFK(@Param("db_name") String db_name, @Param("tb_name") String tb_name, @Param("fk_name") String fk_name, @Param("fk_column") String fk_column, @Param("ref_db") String ref_db,@Param("ref_table") String ref_table, @Param("ref_column") String ref_column);

    void deleteFk(@Param("db_name") String db_name, @Param("tb_name") String tb_name, @Param("fk_name") String fk_name);

    void insertFkInfo(@Param("fk_table") int fk_table, @Param("fk_column") String fk_column, @Param("fk_name") String fk_name, @Param("ref_table") int ref_table, @Param("ref_column") String ref_column);

    void deleteFkInfo(@Param("fk_table") int fk_table, @Param("fk_column") String fk_column);

    List<String> getRefTable(String db_name,String tb_name);

    List<String> getRefColumn(@Param("ref_table") String ref_table);

    List<fk> getFk(@Param("db_name") String db_name, @Param("tb_name") String tb_name);

    int queryTable(@Param("ref_db") String ref_db,@Param("ref_table") String ref_table);

    List<String> getFkColumn(@Param("db_name") String db_name, @Param("tb_name") String tb_name);
}
