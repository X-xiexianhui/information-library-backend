package com.gxu.informationLibrary.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.dao.authDao;
import com.gxu.informationLibrary.dao.formManageDao;
import com.gxu.informationLibrary.dao.roleDao;
import com.gxu.informationLibrary.entity.roleInfo;
import com.gxu.informationLibrary.server.roleServer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class roleImpl implements roleServer {
    final roleDao roleManager;
    final formManageDao formManage;
    final authDao authManage;

    public roleImpl(roleDao roleManager, formManageDao formManage, authDao authManage) {
        this.roleManager = roleManager;
        this.formManage = formManage;
        this.authManage = authManage;
    }

    @Override
    public List<roleInfo> addRole(String param) {
        roleInfo role= JSON.parseObject(param).toJavaObject(roleInfo.class);
        roleManager.addRole(role);
        List<Integer>formList=formManage.getFormList();
        int role_id=roleManager.queryRoleId(role.getRole_name());
        List<Integer>roleList=new ArrayList<>(role_id);
        if (formList.size()>0){
            authManage.addRoleAuth(roleList,formList);
        }
        return roleManager.queryRole("");
    }

    @Override
    public List<roleInfo> deleteRole(int role_id) {
        roleManager.deleteRole(role_id);
        return roleManager.queryRole("");
    }

    @Override
    public List<roleInfo> queryRole(String role_name) {
        return roleManager.queryRole(role_name);
    }

    public roleInfo queryRole(int role_id){
        return roleManager.queryById(role_id);
    }

    public List<Map<String,Object>>queryRole(){
        return roleManager.getRoleSelect();
    }

    @Override
    public List<roleInfo> editRole(String Param) {
        JSONObject roleJSON=JSON.parseObject(Param);
        roleManager.editRole(roleJSON.getString("col_name"),roleJSON.getString("value"));
        return roleManager.queryRole("");
    }
}
