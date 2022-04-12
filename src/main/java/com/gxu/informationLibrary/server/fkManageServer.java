package com.gxu.informationLibrary.server;

import com.gxu.informationLibrary.entity.fk;

import java.util.List;

public interface fkManageServer {
    void addFk();
    void deleteFk();
    void alterFk();
    List<fk>getFk();
}
