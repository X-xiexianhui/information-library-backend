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

    void editAuth();

    roleAuth queryByName(@Param("role_name") String role_name);
}
