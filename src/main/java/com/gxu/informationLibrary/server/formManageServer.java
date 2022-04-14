package com.gxu.informationLibrary.server;

import com.gxu.informationLibrary.entity.formStruct;
import com.gxu.informationLibrary.entity.formTable;

import java.util.List;

public interface formManageServer {
    List<formStruct> addForm();
    List<formTable> deleteForm();
    List<formTable> queryForm();
    List<formStruct> editForm();
}
