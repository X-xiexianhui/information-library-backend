package com.gxu.informationLibrary.controller;

import com.gxu.informationLibrary.entity.response;
import com.gxu.informationLibrary.entity.roleAuth;
import com.gxu.informationLibrary.serviceImpl.authImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class authController {
    private final authImpl authManage;

    public authController(authImpl authManage) {
        this.authManage = authManage;
    }


    @GetMapping("api/auth/query")
    public response<List<roleAuth>>getAuth(@RequestParam("role_name") String role_name) {
        List<roleAuth> data = new ArrayList<>();
        try {
            data = authManage.getAuth(role_name);
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), data);
        }
        return new response<>(data);
    }

    @GetMapping("api/auth/name")
    public response<roleAuth> queryByName(@RequestParam("role_name") String role_name) {
        roleAuth data = new roleAuth();
        try {
            data = authManage.queryByName(role_name);
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), data);
        }
        return new response<>(data);
    }

    @PostMapping("api/auth/edit")
    public response<List<roleAuth>> editAuth(@RequestBody String param) {
        List<roleAuth> data = new ArrayList<>();
        try {
            data = authManage.editAuth(param);
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), data);
        }
        return new response<>(data);
    }
}
