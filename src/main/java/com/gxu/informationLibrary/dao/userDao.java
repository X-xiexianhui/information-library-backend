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

    void editUser(@Param("user_id") String user_id,@Param("col_name") String col_name,@Param("value") String value);

    Map<String,String> checkUser(@Param("user_id") String user_id);

    String queryEmail(@Param("user_id") String user_id);
}
