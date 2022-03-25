package com.gxu.informationLibrary.controller;

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
    public response<String> addTable(@RequestBody String Param){
        try {
            tbManage.createTable(Param);
        } catch (Exception e){
            return new response<>(500, String.valueOf(e.getMessage()), "");
        }
        return new response<>("");
    }
    @GetMapping("/tb/column/get")
    public response<List<String>>getColumn(@RequestParam(value="dbName",required=false)String dbName, @RequestParam(value = "tbName",required=false)String tbName){
           List<String>data=new ArrayList<>();
            try {
                data=tbManage.getColumns(dbName,tbName);
            } catch (Exception e){
                return new response<>(500,e.getMessage(),data);
            }
            return new response<>(data);
    }
}
