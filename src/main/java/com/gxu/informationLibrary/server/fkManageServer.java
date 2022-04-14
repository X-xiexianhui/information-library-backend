package com.gxu.informationLibrary.server;

import com.gxu.informationLibrary.entity.fk;

import java.util.List;

public interface fkManageServer {
    List<fk> alterFk(String param);

    List<fk> getFk(String db_name, String tb_name);
}
