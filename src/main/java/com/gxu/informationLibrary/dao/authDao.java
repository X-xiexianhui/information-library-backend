package com.gxu.informationLibrary.dao;

import com.gxu.informationLibrary.entity.roleAuth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface authDao {
    List<roleAuth>getAuth(@Param("role_name") String role_name);

    void editAuth(@Param("role_name") String role_name,@Param("form_name") String form_name,@Param("col_name") String col_name,@Param("value") String value);

    roleAuth queryByName(@Param("role_name") String role_name);

    void addRoleAuth(List<Integer>roleList,List<Integer>formList);
}
