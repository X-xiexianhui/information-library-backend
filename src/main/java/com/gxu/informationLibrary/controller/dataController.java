package com.gxu.informationLibrary.controller;

import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.entity.recycleBin;
import com.gxu.informationLibrary.entity.response;
import com.gxu.informationLibrary.entity.statisticsResult;
import com.gxu.informationLibrary.serviceImpl.dataImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    public response<List<Map<String, String>>> getTableColumn(@RequestParam("form_id") int form_id) {
        return dataManage.getTableColumn(form_id);
    }

    @PostMapping("api/data/add")
    public response<String> insertData(@RequestBody String parma, HttpServletRequest request) {
        return dataManage.insertData(parma, request);
    }

    @PostMapping("api/data/edit")
    public response<String> editData(@RequestBody String parma) {
        return dataManage.updateData(parma);
    }

    @PostMapping("api/data/delete")
    public response<String> deleteData(@RequestBody String parma) {
        return dataManage.deleteData(parma);
    }

    @PostMapping("api/data/query")
    public response<List<JSONObject>> queryData(@RequestBody String parma, HttpServletRequest request) {
        return dataManage.queryData(parma, request);
    }

    @PostMapping("api/file/add")
    public response<String> uploadFile(@RequestParam("file") MultipartFile file) {
        return dataManage.uploadFile(file);
    }

    @PostMapping("api/file/download")
    public void downloadFile(@RequestBody String parma, HttpServletResponse response) throws IOException {
        dataManage.downloadFile(parma,response);
    }
    @PostMapping("api/data/dump")
    public String dumpData() {
        return dataManage.dumpData();
    }

    @PostMapping("api/data/roll")
    public String rollData(@RequestParam String file_name) {
        return dataManage.rollBack(file_name);
    }

    @GetMapping("api/dump/get")
    public response<List<JSONObject>> getDumpList(@RequestParam("dump_time") String dump_time) {
        return dataManage.getDumpList(dump_time);
    }

    @PostMapping("api/data/statistics")
    public response<statisticsResult> statisticsData(@RequestBody String parma, HttpServletRequest request) {
        return dataManage.statistics(parma, request);
    }

    @PostMapping("api/recycle/clear")
    public response<Boolean> clearAll(@RequestParam("form_id") int form_id, HttpServletRequest request) {
        return dataManage.clearRecycle(request, form_id);
    }

    @PostMapping("api/recycle/delete")
    public response<Boolean> clear(@RequestParam("id") int id) {
        return dataManage.deleteRecycleData(id);
    }

    @PostMapping("api/recycle/restore")
    public response<Boolean> restore(@RequestBody String parma) {
        return dataManage.restoreData(parma);
    }

    @PostMapping("api/recycle/restore/all")
    public response<Boolean> restoreAll(@RequestParam("form_id") int form_id, HttpServletRequest request) {
        return dataManage.restoreAllData(form_id, request);
    }

    @PostMapping("api/recycle/query")
    public response<List<recycleBin>> queryRecycleData(@RequestBody String parma, HttpServletRequest request) {
        return dataManage.queryRecycleData(parma, request);
    }
}
