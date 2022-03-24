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
    @PostMapping("/db/add")
    public response<String> addDB(@RequestParam("dbName") String dbName) {
        try {
            dbManage.createDB(dbName);
        } catch (Exception e) {
            return new response<>(500, String.valueOf(e.getCause()), null);
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
            return new response<>(500, String.valueOf(e.getCause()), null);
        }
        return new response<>(null);
    }

    //    查询某个数据库
    @GetMapping("/db/get")
    public response<List<dbInfo>> getDB(@RequestParam("dbName") String dbName) {
        List<dbInfo> data = new ArrayList<>();
        try {
            data = dbManage.getDB(dbName);
        } catch (Exception e) {
            return new response<>(500, String.valueOf(e.getCause()), data);
        }
        return new response<>(data);
    }

    //    查询所有数据库
    @GetMapping("/db/all")
    public response<List<dbInfo>> getAllDB() {
        List<dbInfo> data = new ArrayList<>();
        try {
            data = dbManage.getAllDB();
        } catch (Exception e) {
            return new response<>(500, String.valueOf(e.getCause()), data);
        }
        return new response<>(data);
    }
}
