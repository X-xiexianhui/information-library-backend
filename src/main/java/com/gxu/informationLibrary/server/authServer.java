package com.gxu.informationLibrary.server;

import com.gxu.informationLibrary.entity.roleAuth;

import java.util.List;

public interface authServer {
    List<roleAuth>getAuth(String role_name);

    List<roleAuth> editAuth(String parma);
}
