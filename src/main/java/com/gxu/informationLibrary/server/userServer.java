package com.gxu.informationLibrary.server;

import com.gxu.informationLibrary.entity.response;
import com.gxu.informationLibrary.entity.userInfo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface userServer {
    List<userInfo>addUser(String param);

    List<userInfo>deleteUser(String user_id);

    List<userInfo>queryUser(String user_name);

    List<userInfo>editUser(String param);

    response<String> login(String parma, HttpServletResponse response) throws Exception;
}
