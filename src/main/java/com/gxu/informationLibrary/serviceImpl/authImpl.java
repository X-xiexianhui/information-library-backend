package com.gxu.informationLibrary.serviceImpl;

import com.gxu.informationLibrary.dao.authDao;
import com.gxu.informationLibrary.entity.roleAuth;
import com.gxu.informationLibrary.server.authServer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class authImpl implements authServer {
    final authDao auth;

    public authImpl(authDao auth) {
        this.auth = auth;
    }

    @Override
    public List<roleAuth> getAuth(String role_name) {
        return auth.getAuth(role_name);
    }
    public roleAuth queryByName(String role_name) {
        return auth.queryByName(role_name);
    }
    @Override
    public void editAuth() {

    }
}
