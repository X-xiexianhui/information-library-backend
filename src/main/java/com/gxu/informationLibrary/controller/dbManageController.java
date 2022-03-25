package com.gxu.informationLibrary.controller;

import com.gxu.informationLibrary.entity.dbInfo;
import com.gxu.informationLibrary.entity.response;
import com.gxu.informationLibrary.serviceImpl.dbManageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class dbManageController {
    final dbManageImpl dbManage;

    public dbManageController(dbManageImpl dbManage) {
        this.dbManage = dbManage;
    }

    //    新建数据库
    @PostMapping("/db/create")
    public response<String> createDB(@RequestParam("dbName") String dbName) {
        try {
            dbManage.createDB(dbName);
        } catch (Exception e) {
            return new response<>(500, e.getMessage(), null);
        }
        return new response<>(null);
    }

    //    删除数据库
    @DeleteMapping("/db/delete")
    public response<String> deleteDB(@RequestParam("dbName") String dbName) {
        try {
            int tbs =dbManage.getTables(dbName);
            if (tbs>0){
                return new response<>(500,"数据库非空，不允许删除",null);
            }
            dbManage.deleteDB(dbName);
        } catch (Exception e) {
            return new response<>(500, e.getMessage(), null);
        }
        return new response<>(null);
    }

    //    查询数据库
    @GetMapping("/db/search")
    public response<List<dbInfo>> searchDB(@RequestParam("dbName") String dbName) {
        List<dbInfo> data = new ArrayList<>();
        try {
            data = dbManage.searchDB(dbName);
        } catch (Exception e) {
            return new response<>(500, e.getMessage(), data);
        }
        return new response<>(data);
    }
}
