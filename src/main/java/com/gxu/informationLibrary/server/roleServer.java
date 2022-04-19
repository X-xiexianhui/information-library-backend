package com.gxu.informationLibrary.server;

import com.gxu.informationLibrary.entity.roleInfo;

import java.util.List;

public interface roleServer {
    List<roleInfo>addRole(String param);

    List<roleInfo>deleteRole(int role_id);

    List<roleInfo>queryRole(String role_name);

    List<roleInfo>editRole(String Param);
}
