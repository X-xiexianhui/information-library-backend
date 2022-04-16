package com.gxu.informationLibrary.serviceImpl;

import com.gxu.informationLibrary.dao.formManageDao;
import com.gxu.informationLibrary.entity.formStruct;
import com.gxu.informationLibrary.entity.formTable;
import com.gxu.informationLibrary.server.formManageServer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class formManageImpl implements formManageServer {
    final formManageDao formManage;

    public formManageImpl(formManageDao formManage) {
        this.formManage = formManage;
    }

    @Override
    public List<formTable> queryForm(String tb_name) {
        return formManage.query(tb_name);
    }

    @Override
    public void renameForm(String old_name,String new_name) {
        formManage.renameForm(old_name,new_name);
    }

    @Override
    public void editForm() {

    }

    @Override
    public List<formStruct> getFormStruct() {
        return null;
    }
}
