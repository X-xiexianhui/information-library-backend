package com.gxu.informationLibrary.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface indexManageDao {
    void addIndex();
    void dropIndex();
    public List<String>getColumns(String db_name,String tb_name);
}
