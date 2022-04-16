package com.gxu.informationLibrary.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
    public List<formTable> renameForm(String param) {
        JSONObject nameBody= JSON.parseObject(param);
        formManage.renameForm(nameBody.getString("old_name"),nameBody.getString("new_name"));
        return queryForm("");
    }

    @Override
    public void editForm(List<formStruct>formStructs) {
        formManage.editForm(formStructs);
    }

    @Override
    public List<formStruct> getFormStruct(int form_id) {
        return formManage.getFormStruct(form_id);
    }
}
