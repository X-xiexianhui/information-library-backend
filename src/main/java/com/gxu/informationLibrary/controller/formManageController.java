package com.gxu.informationLibrary.controller;

import com.gxu.informationLibrary.entity.formTable;
import com.gxu.informationLibrary.entity.response;
import com.gxu.informationLibrary.serviceImpl.formManageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class formManageController {
    final formManageImpl  formManage;

    public formManageController(formManageImpl formManage) {
        this.formManage = formManage;
    }
    @GetMapping("/form/list")
    public response<List<formTable>> queryForm(@RequestParam("tb_name") String tb_name){
        List<formTable>data=new ArrayList<>();
        try {
            data=formManage.queryForm(tb_name);
        }catch (Exception e){
            return new response<>(500,e.getCause().getMessage(),data);
        }
        return new response<>(data);
    }
    @PostMapping("/form/rename")
    public response<List<formTable>>renameForm(@RequestBody String param){
        List<formTable>data=new ArrayList<>();
        try {
            data=formManage.renameForm(param);
        }catch (Exception e){
            return new response<>(500,e.getCause().getMessage(),data);
        }
        return new response<>(data);
    }
}
