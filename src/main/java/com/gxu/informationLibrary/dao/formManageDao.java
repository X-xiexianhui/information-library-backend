package com.gxu.informationLibrary.dao;

import com.gxu.informationLibrary.entity.formTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface formManageDao {
    List<formTable>query(@Param("tb_name")String tb_name);
}
