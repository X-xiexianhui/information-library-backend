package com.gxu.informationLibrary.controller;

import com.gxu.informationLibrary.entity.fk;
import com.gxu.informationLibrary.entity.refInfo;
import com.gxu.informationLibrary.entity.response;
import com.gxu.informationLibrary.serviceImpl.fkManageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class fkManageController {
    final fkManageImpl fkManage;

    public fkManageController(fkManageImpl fkManage) {
        this.fkManage = fkManage;
    }

    @GetMapping("api/fk/ref")
    public response<refInfo> getRefInfo(@RequestParam("db_name") String db_name, @RequestParam("tb_name") String tb_name) {
        refInfo data = new refInfo();
        try {
            data = fkManage.getRef(db_name, tb_name);
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), data);
        }
        return new response<>(data);
    }

    @GetMapping("api/fk/get")
    public response<List<fk>> getFk(@RequestParam("db_name") String db_name, @RequestParam("tb_name") String tb_name) {
        List<fk> data = new ArrayList<>();
        try {
            data = fkManage.getFk(db_name, tb_name);
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), data);
        }
        return new response<>(data);
    }

    @PostMapping("api/fk/alter")
    public response<List<fk>> alterFk(@RequestBody String parma) {
        List<fk> data = new ArrayList<>();
        try {
            data = fkManage.alterFk(parma);
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), data);
        }
        return new response<>(data);
    }

    @GetMapping("api/fk/column")
    public response<List<String>> getFkColumn(@RequestParam("db_name") String db_name, @RequestParam("tb_name") String tb_name) {
        List<String> data = new ArrayList<>();
        try {
            data = fkManage.getFkColumn(db_name, tb_name);
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), data);
        }
        return new response<>(data);
    }
}
