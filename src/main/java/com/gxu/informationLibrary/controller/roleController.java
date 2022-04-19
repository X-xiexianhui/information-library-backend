package com.gxu.informationLibrary.controller;

import com.gxu.informationLibrary.entity.response;
import com.gxu.informationLibrary.entity.roleInfo;
import com.gxu.informationLibrary.serviceImpl.roleImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class roleController {
    final roleImpl roleManager;

    public roleController(roleImpl roleManager) {
        this.roleManager = roleManager;
    }

    @PostMapping("api/role/add")
    public response<List<roleInfo>> addRole(@RequestBody String param) {
        List<roleInfo> data = new ArrayList<>();
        try {
            data = roleManager.addRole(param);
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), data);
        }
        return new response<>(data);
    }

    @GetMapping("api/role/delete")
    public response<List<roleInfo>> deleteRole(@RequestParam("role_id") int role_id) {
        List<roleInfo> data = new ArrayList<>();
        try {
            data = roleManager.deleteRole(role_id);
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), data);
        }
        return new response<>(data);
    }

    @GetMapping("api/role/query")
    public response<List<roleInfo>> queryRole(@RequestParam("role_name") String role_name) {
        List<roleInfo> data = new ArrayList<>();
        try {
            data = roleManager.queryRole(role_name);
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), data);
        }
        return new response<>(data);
    }

    @GetMapping("api/role/id")
    public response<roleInfo> queryById(@RequestParam("role_id") int role_id) {
        roleInfo data = new roleInfo();
        try {
            data = roleManager.queryRole(role_id);
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), data);
        }
        return new response<>(data);
    }

    @GetMapping("api/role/select")
    public response<List<Map<String, Object>>> roleSelect() {
        List<Map<String, Object>> data = new ArrayList<>();
        try {
            data = roleManager.queryRole();
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), data);
        }
        return new response<>(data);
    }

    @PostMapping("api/role/edit")
    public response<List<roleInfo>> editRole(@RequestBody String param) {
        List<roleInfo> data = new ArrayList<>();
        try {
            data = roleManager.editRole(param);
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), data);
        }
        return new response<>(data);
    }
}
