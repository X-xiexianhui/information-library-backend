package com.gxu.informationLibrary.controller;

import com.gxu.informationLibrary.entity.response;
import com.gxu.informationLibrary.serviceImpl.dataImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class dataController {
    private final dataImpl dataManage;

    public dataController(dataImpl dataManage) {
        this.dataManage = dataManage;
    }
    @GetMapping("api/data/column")
    public response<List<Map<String,String>>>getTableColumn(@RequestParam("form_id")int form_id){
        return dataManage.getTableColumn(form_id);
    }
}
