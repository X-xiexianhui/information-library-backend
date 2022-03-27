package com.gxu.informationLibrary.dao;

import com.gxu.informationLibrary.entity.dbInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface dbManageDao {
    void createDbDao(@Param("db_name") String db_name);
    void deleteDbDao(@Param("db_name") String db_name);
    List<dbInfo> searchDbDao(@Param("query_name") String db_name);
    int getTables(@Param("db_name") String db_name);
}