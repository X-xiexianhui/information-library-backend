package com.gxu.informationLibrary.controller;

import com.gxu.informationLibrary.entity.response;
import com.gxu.informationLibrary.entity.userInfo;
import com.gxu.informationLibrary.serviceImpl.mailServer;
import com.gxu.informationLibrary.serviceImpl.userImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class userController {
    final userImpl userManager;
    private final mailServer mail;

    public userController(userImpl userManager, mailServer mail) {
        this.userManager = userManager;
        this.mail = mail;
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

    @GetMapping("api/user/get")
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

    @PostMapping("api/user/login")
    public response<String> login(@RequestBody String parma, HttpServletResponse res) {
        return userManager.login(parma, res);
    }

    @PostMapping("api/user/check")
    public response<Boolean> checkUser(@RequestParam("user_id") String user_id) {
        response<Boolean> res;
        try {
            res = mail.sendMimeMail(user_id).get();
        } catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), false);
        }
        return res;
    }

    @PostMapping("api/email/check")
    public response<Boolean> checkEmailCode(@RequestBody String parma) {
        return mail.checkAuthCode(parma);
    }

    @PostMapping("api/pwd/reset")
    public response<Boolean> resetPwd(@RequestBody String parma) {
        return userManager.resetPwd(parma);
    }

    @PostMapping("api/pwd/edit")
    public response<Boolean> editPwd(@RequestBody String parma, HttpServletRequest request) {
        return userManager.editPwd(parma, request);
    }

    @GetMapping("api/user/query")
    public response<userInfo>getUser(HttpServletRequest request){
        userInfo data =new userInfo();
        try {
            data=userManager.queryUserById(request);
        }catch (Exception e){
            return new response<>(500,e.getCause().getMessage(),data);
        }
        return new response<>(data);
    }
}
