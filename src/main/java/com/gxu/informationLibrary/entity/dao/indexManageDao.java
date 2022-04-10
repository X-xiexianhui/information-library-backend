package com.gxu.informationLibrary.entity.dao;

import com.gxu.informationLibrary.entity.index;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface indexManageDao {
    void addIndex(@Param("index_name") String index_name,String db_name,String tb_name,@Param("fieldss") List<String>fields,@Param("uni") boolean uni);
    void dropIndex(@Param("db_name") String db_name,@Param("tb_name") String tb_name,@Param("index_name") String index_name);
    List<String>getColumns(@Param("db_name") String db_name,@Param("tb_name") String tb_name);
    List<index> getIndex(@Param("db_name") String db_name,@Param("tb_name") String tb_name);
}
