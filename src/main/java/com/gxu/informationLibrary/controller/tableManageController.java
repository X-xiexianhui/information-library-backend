package com.gxu.informationLibrary.controller;

import com.gxu.informationLibrary.entity.Columns;
import com.gxu.informationLibrary.entity.response;
import com.gxu.informationLibrary.serviceImpl.tbManageImpl;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@ResponseBody
public class tableManageController {
    final tbManageImpl tbManage;

    public tableManageController(tbManageImpl tbManage) {
        this.tbManage = tbManage;
    }

    @PostMapping("/tb/add")
    public response<String> addTable(@RequestBody String Param){
        try {
            JSONObject jsonParam= new JSONObject(Param);
            List<Object>columns=new Columns(jsonParam.getJSONArray("column")).getColumns();
            System.out.println(columns.get(0));
            tbManage.createTable(jsonParam.getString("dbName"), jsonParam.getString("tbName"),columns );
        } catch (Exception e){
            return new response<>(500, String.valueOf(e.getMessage()), "");
        }
        return new response<>("");
    }
}
