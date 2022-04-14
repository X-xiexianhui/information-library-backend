package com.gxu.informationLibrary.server;

import com.gxu.informationLibrary.entity.formTable;

import java.util.List;

public interface formManageServer {
    void addForm();
    List<formTable> deleteForm();
    List<formTable> queryForm();
    void editForm();
}
