package com.gxu.informationLibrary.server;

import com.gxu.informationLibrary.entity.formStruct;
import com.gxu.informationLibrary.entity.formTable;

import java.util.List;

public interface formManageServer {
    List<formTable> queryForm(String tb_name);

    void renameForm(String pld_name,String new_name);

    void editForm();

    List<formStruct> getFormStruct();
}
