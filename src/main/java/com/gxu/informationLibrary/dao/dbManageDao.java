package com.gxu.informationLibrary.dao;

import com.gxu.informationLibrary.entity.dbInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface dbManageDao {
    void createDb(@Param("db_name") String db_name);

    void deleteDb(@Param("db_name") String db_name);

    List<dbInfo> searchDb(@Param("query_name") String db_name);

    int getTables(@Param("db_name") String db_name);
}