package com.gxu.informationLibrary.dao;

import com.gxu.informationLibrary.entity.roleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface roleDao {
    void addRole(@Param("role") roleInfo role);

    void  deleteRole(@Param("role_id") int role_id);

    List<roleInfo>queryRole(@Param("role_name") String role_name);

    roleInfo queryById(@Param("role_id") int role_id);

    List<Map<String,Object>>getRoleSelect();

    void editRole(@Param("col_name") String col_name,@Param("value") String value);

    List<Integer>getRoleList();
}
