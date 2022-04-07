package com.gxu.informationLibrary.dao;

import com.gxu.informationLibrary.entity.index;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface indexManageDao {
    void addIndex();
    void dropIndex(int index_id);
    List<String>getColumns(String db_name,String tb_name);
    List<index> getIndex(String db_name, String tb_name);
}
