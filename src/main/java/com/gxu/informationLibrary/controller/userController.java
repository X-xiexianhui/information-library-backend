package com.gxu.informationLibrary.controller;

import com.gxu.informationLibrary.entity.response;
import com.gxu.informationLibrary.entity.userInfo;
import com.gxu.informationLibrary.serviceImpl.userImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class userController {
    final userImpl userManager;

    public userController(userImpl userManager) {
        this.userManager = userManager;
    }

    @PostMapping("api/user/add")
    public response<List<userInfo>> addUser(@RequestBody String param) {
        List<userInfo> data = new ArrayList<>();
        try {
            data = userManager.addUser(param);
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), data);
        }
        return new response<>(data);
    }

    @PostMapping("api/user/delete")
    public response<List<userInfo>> deleteUser(@RequestParam("user_id") String user_id) {
        List<userInfo> data = new ArrayList<>();
        try {
            data = userManager.deleteUser(user_id);
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), data);
        }
        return new response<>(data);
    }

    @GetMapping("pai/user/get")
    public response<List<userInfo>> queryUser(@RequestParam("user_name") String user_name) {
        List<userInfo> data = new ArrayList<>();
        try {
            data = userManager.queryUser(user_name);
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), data);
        }
        return new response<>(data);
    }

    @PostMapping("api/user/edit")
    public response<List<userInfo>> editUser(@RequestBody String param) {
        List<userInfo> data = new ArrayList<>();
        try {
            data = userManager.editUser(param);
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), data);
        }
        return new response<>(data);
    }
}
