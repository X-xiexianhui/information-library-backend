package com.gxu.informationLibrary.dao;

import com.gxu.informationLibrary.entity.userInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface userDao {
    void addUser(@Param("user") userInfo user);

    void deleteUser(@Param("user_id") String user_id);

    List<userInfo>queryUser(@Param("user_name") String user_name);

    <T>void editUser(@Param("user_id") String user_id,@Param("col_name") String col_name,@Param("value") T value);

    Map<String,String> checkUser(@Param("user_id") String user_id);

    String queryEmail(@Param("user_id") String user_id);

    String getPwd(@Param("user_id") String user_id);

    Map<String,Object> checkExist(@Param("user_id") String user_id);

    userInfo queryUserById(@Param("user_id") String user_id);
}
