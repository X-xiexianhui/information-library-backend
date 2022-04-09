package com.gxu.informationLibrary.dao;

import com.gxu.informationLibrary.entity.index;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface indexManageDao {
    void addIndex();
    void dropIndex(@Param("db_name") String db_name,@Param("tb_name") String tb_name,@Param("index_name") String index_name);
    List<String>getColumns(@Param("db_name") String db_name,@Param("tb_name") String tb_name);
    List<index> getIndex(@Param("db_name") String db_name,@Param("tb_name") String tb_name);
}
