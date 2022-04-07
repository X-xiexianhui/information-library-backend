package com.gxu.informationLibrary.dao;

import java.util.List;

public interface indexManageDao {
    void addIndex();
    void dropIndex();
    public List<String>getColumns(String db_name,String tb_name);
}
