package com.gxu.informationLibrary.server;

import com.gxu.informationLibrary.entity.formStruct;
import com.gxu.informationLibrary.entity.formTable;

import java.util.List;

public interface formManageServer {
    List<formTable> queryForm();

    void renameForm();

    void editForm();

    List<formStruct> getFormStruct();
}
