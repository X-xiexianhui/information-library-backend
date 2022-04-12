package com.gxu.informationLibrary.controller;

import com.gxu.informationLibrary.entity.fk;
import com.gxu.informationLibrary.entity.refInfo;
import com.gxu.informationLibrary.entity.response;
import com.gxu.informationLibrary.serviceImpl.fkManageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class fkManageController {
    final fkManageImpl fkManage;

    public fkManageController(fkManageImpl fkManage) {
        this.fkManage = fkManage;
    }

    @GetMapping("/fk/ref")
    public response<refInfo>getRefInfo(){
        refInfo data=new refInfo();
        try {
            List<String>ref_table=fkManage.getRefTable();
            data.setRef_table(ref_table);
            for (String ref:ref_table) {
                List<String>ref_column=fkManage.getRefColumn(ref);
                Map<String,List<String>>column=new HashMap<>();
                column.put(ref,ref_column);
                data.setRef_column(column);
            }
        } catch (Exception e){
            return new response<>(500,e.getCause().getMessage(),data);
        }
        return new response<>(data);
    }
    @GetMapping("/fk/get")
    public response<List<fk>>getFk(@RequestParam("db_name") String db_name, @RequestParam("tb_name") String tb_name){
        List<fk>data=new ArrayList<>();
        try {
            data=fkManage.getFk(db_name,tb_name);
        }catch (Exception e){
            return new response<>(500,e.getCause().getMessage(),data);
        }
        return new response<>(data);
    }
    @PostMapping("/fk/alter")
    public response<List<fk>>alterFk(@RequestBody String parma){
        List<fk>data=new ArrayList<>();
        try {
            data=fkManage.alterFk(parma);
        }catch (Exception e){
            return new response<>(500,e.getCause().getMessage(),data);
        }
        return new response<>(data);
    }
    @GetMapping("/fk/column")
    public response<List<String>>getFkColumn(@RequestParam("db_name") String db_name, @RequestParam("tb_name") String tb_name){
        List<String>data=new ArrayList<>();
        try {
            data=fkManage.getFkColumn(db_name,tb_name);
        }catch (Exception e){
            return new response<>(500,e.getCause().getMessage(),data);
        }
        return new response<>(data);
    }
}
