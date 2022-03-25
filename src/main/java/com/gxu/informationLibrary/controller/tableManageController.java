package com.gxu.informationLibrary.controller;

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
    public response<List<column>> addTable(@RequestBody String Param){
        List<column>data=new ArrayList<>();
        try {
            data=tbManage.createTable(Param);
        } catch (Exception e){
            return new response<>(500, String.valueOf(e.getMessage()), data);
        }
        return new response<>(data);
    }
}
