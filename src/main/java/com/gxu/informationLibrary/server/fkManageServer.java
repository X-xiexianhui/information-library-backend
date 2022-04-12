package com.gxu.informationLibrary.server;

import com.gxu.informationLibrary.entity.fk;

import java.util.List;

public interface fkManageServer {
    void addFk(String db_name,String tb_name,List<fk>insert);
    void deleteFk(String db_name,String tb_name,List<fk>remove);
    void alterFk(String db_name,String tb_name,List<fk>update);
    List<fk>getFk();
}
