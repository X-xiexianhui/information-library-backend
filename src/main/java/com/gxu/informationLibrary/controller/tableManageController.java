package com.gxu.informationLibrary.controller;

import com.gxu.informationLibrary.entity.response;
import com.gxu.informationLibrary.serviceImpl.tbManageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;



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
}
