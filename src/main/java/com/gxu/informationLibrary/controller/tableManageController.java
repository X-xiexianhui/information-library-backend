package com.gxu.informationLibrary.controller;


import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.entity.column;
import com.gxu.informationLibrary.entity.response;
import com.gxu.informationLibrary.serviceImpl.tbManageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@ResponseBody
public class tableManageController {
    final tbManageImpl tbManage;

    public tableManageController(tbManageImpl tbManage) {
        this.tbManage = tbManage;
    }

    @PostMapping("/tb/add")
    public response<List<JSONObject>> addTable(@RequestBody String Param){
        List<JSONObject>data=new ArrayList<>();
        try {
            data=tbManage.createTable(Param);
        } catch (Exception e){
            return new response<>(500, String.valueOf(e.getMessage()), data);
        }
        return new response<>(data);
    }
    @DeleteMapping("/tb/delete")
    public response<String>deleteTable(@RequestParam("dbName")String dbName,@RequestParam("tbName")String tbName){
        try {
            tbManage.deleteTable(dbName,tbName);
        }catch (Exception e){
            return new response<>(500,e.getMessage(),"");
        }
        return new response<>("");
    }
    @GetMapping("/tb/test")
    public response<List<JSONObject>>test(@RequestParam("dbName")String dbName, @RequestParam("tbName")String tbName){
        List<JSONObject> data=new ArrayList<>();
        try {
            data=this.tbManage.test(dbName,tbName);
        }catch (Exception e){
            return new response<>(500,e.getMessage(),data);
        }
        return new response<>(data);
    }
}
