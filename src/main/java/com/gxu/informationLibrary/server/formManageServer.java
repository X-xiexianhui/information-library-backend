package com.gxu.informationLibrary.server;

import com.gxu.informationLibrary.entity.formStruct;
import com.gxu.informationLibrary.entity.formTable;

import java.util.List;

public interface formManageServer {
    List<formTable> deleteForm();

    List<formTable> queryForm();

    List<formTable> renameForm();

    List<formStruct> editForm();
}
