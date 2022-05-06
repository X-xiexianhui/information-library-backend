package com.gxu.informationLibrary.dao;

import com.gxu.informationLibrary.entity.dbInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface dbManageDao {
//    创建数据库
    void createDb(@Param("db_name") String db_name);

//    删除数据库
    void deleteDb(@Param("db_name") String db_name);

//    查询数据库
    List<dbInfo> searchDb(@Param("query_name") String db_name);

//    统计数据库存在的表数量
    int getTables(@Param("db_name") String db_name);

//    获取数据库列表
    List<String>getDatabaseList();

//    备份数据库
    void dumpDataBase(@Param("file_name") String file_name,@Param("dump_time") String dump_time);
}