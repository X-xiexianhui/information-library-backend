package com.gxu.informationLibrary.controller;


import com.gxu.informationLibrary.entity.index;
import com.gxu.informationLibrary.entity.response;
import com.gxu.informationLibrary.serviceImpl.indexManageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class indexManageController {
    final indexManageImpl indexManage;

    public indexManageController(indexManageImpl indexManage) {
        this.indexManage = indexManage;
    }

    @PostMapping("api/index/alter")
    public response<List<index>> indexManage(@RequestBody String Parma) {
        List<index> data = new ArrayList<>();
        try {
            data = indexManage.alterIndex(Parma);
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), data);
        }
        return new response<>(data);
    }

    @GetMapping("api/index/column")
    public response<List<String>> getColumns(@RequestParam("db_name") String db_name, @RequestParam("tb_name") String tb_name) {
        List<String> data = new ArrayList<>();
        try {
            data = indexManage.getColumns(db_name, tb_name);
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), data);
        }
        return new response<>(data);
    }

    @GetMapping("api/index/get")
    public response<List<index>> getIndex(@RequestParam("db_name") String db_name, @RequestParam("tb_name") String tb_name) {
        List<index> data = new ArrayList<>();
        try {
            data = indexManage.getIndex(db_name, tb_name);
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), data);
        }
        return new response<>(data);
    }
}
