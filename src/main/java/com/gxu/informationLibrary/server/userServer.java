package com.gxu.informationLibrary.server;

import com.gxu.informationLibrary.entity.userInfo;

import java.util.List;

public interface userServer {
    List<userInfo>addUser(String param);

    List<userInfo>deleteUser(String user_id);

    List<userInfo>queryUser(String user_name);

    List<userInfo>editUser(String param);
}
