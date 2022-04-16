package com.gxu.informationLibrary.server;

import com.gxu.informationLibrary.entity.formStruct;
import com.gxu.informationLibrary.entity.formTable;

import java.util.List;

public interface formManageServer {
    List<formTable> queryForm(String tb_name);

    List<formTable> renameForm(String param);

    void editForm(List<formStruct>formStructs);

    List<formStruct> getFormStruct(int form_id);
}
