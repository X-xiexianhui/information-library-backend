package com.gxu.informationLibrary.controller;

import com.gxu.informationLibrary.entity.refInfo;
import com.gxu.informationLibrary.entity.response;
import com.gxu.informationLibrary.serviceImpl.fkManageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
