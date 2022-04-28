package com.gxu.informationLibrary.dao;

import com.gxu.informationLibrary.entity.menuInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface menuDao {
    void addMenu(@Param("menu") menuInfo menu);

    void deleteMenu(@Param("menu_id") int menu_id);

    List<menuInfo>query(@Param("menu_name") String menu_name);

    menuInfo getMenuById(@Param("menu_id") int menu_id);

    List<Map<String,Object>>getMenuSelect();

    void editMenu(@Param("col_name") String col_name,@Param("value") String value);

    List<Map<String,Object>> initMenu();
}
