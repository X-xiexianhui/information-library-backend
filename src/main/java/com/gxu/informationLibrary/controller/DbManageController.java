package com.gxu.informationLibrary.controller;

import com.gxu.informationLibrary.serviceImpl.dbManagerImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@Controller
public class DbManageController {
    private final dbManagerImpl dbManager;

    public DbManageController(dbManagerImpl dbManager) {
        this.dbManager = dbManager;
    }
    @ResponseBody
    @PostMapping("/db/add")
    public JSONObject createDB(@RequestBody JSONObject dbConfig){
        dbManager.createDB(dbConfig);
        return new JSONObject();
    }
    @DeleteMapping("/db/delete")
    void deleteDB(@RequestParam("dbName") String dbName){
        dbManager.deleteDB(dbName);
    }
    @GetMapping("/db/get")
    void getDB(@RequestParam("dbName") String dbName){
        dbManager.searchDB(dbName);
    }
    @GetMapping("/db/all")
    void getAllDB(){
        dbManager.searchAllDB();
    }
    @PostMapping("/db/alter")
    void alterDB(@RequestBody JSONObject alterConfig){
        dbManager.alterDB(alterConfig);
    }
}
