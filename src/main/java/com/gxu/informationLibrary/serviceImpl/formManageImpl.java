package com.gxu.informationLibrary.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.dao.formManageDao;
import com.gxu.informationLibrary.entity.formStruct;
import com.gxu.informationLibrary.entity.formTable;
import com.gxu.informationLibrary.server.formManageServer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(rollbackFor=Exception.class)
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
        formManage.renameForm(nameBody.getString("old_name"),nameBody.getString("new_name"), nameBody.getIntValue("form_id") );
        return queryForm("");
    }

    @Override
    public List<formStruct> editForm(String param) {
        JSONObject structList=JSON.parseObject(param);
        List<formStruct>formStructs=structList.getJSONArray("update").toJavaList(formStruct.class);
        formManage.editForm(formStructs);
        return formManage.getFormStruct(structList.getInteger("form_id"));
    }

    @Override
    public List<formStruct> getFormStruct(int form_id) {
        return formManage.getFormStruct(form_id);
    }
}
