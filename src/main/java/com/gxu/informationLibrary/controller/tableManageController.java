package com.gxu.informationLibrary.controller;


import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.entity.response;
import com.gxu.informationLibrary.entity.table;
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

    @PostMapping("api/tb/add")
    public response<List<JSONObject>> addTable(@RequestBody String Param){
        List<JSONObject>data=new ArrayList<>();
        try {
            data=tbManage.createTable(Param);
        } catch (Exception e){
            return new response<>(500, e.getMessage(), data);
        }
        return new response<>(data);
    }
    @DeleteMapping("api/tb/delete")
    public response<String>deleteTable(@RequestParam("db_name")String db_name, @RequestParam("tb_name")String tb_name){
        try {
            tbManage.deleteTable(db_name, tb_name);
        }catch (Exception e){
            return new response<>(500,e.getMessage(),"");
        }
        return new response<>("");
    }
    @GetMapping("api/tb/search")
    public response<List<table>>searchTables(@RequestParam("query_name")String tb_name){
        List<table>data= new ArrayList<>();
        try {
            data=tbManage.searchTable(tb_name);
        } catch (Exception e){
            return new response<>(500,e.getMessage(),data);
        }
        return new response<>(data);
    }
    @PostMapping("api/tb/rename")
    public response<String>renameTable(@RequestBody String Param){
        try {
            tbManage.renameTable(Param);
        }catch (Exception e){
            return new response<>(500,e.getMessage(),"");
        }
        return new response<>("");
    }
    @PostMapping("api/tb/alter")
    public response<List<JSONObject>>alterTable(@RequestBody String Param){
        List<JSONObject>data=new ArrayList<>();
        try {
            data=tbManage.alterTable(Param);
        } catch (Exception e){
            return new response<>(500,e.getCause().getMessage(), data);
        }
        return new response<>(data);
    }
    @GetMapping("api/tb/column")
    public response<List<JSONObject>>gettableColumn(@RequestParam("db_name")String db_name,@RequestParam("tb_name")String tb_name){
        List<JSONObject>data= new ArrayList<>();
        try {
            data=tbManage.getColumn(db_name,tb_name);
        } catch (Exception e){
            return new response<>(500,e.getMessage(),data);
        }
        return new response<>(data);
    }
}
