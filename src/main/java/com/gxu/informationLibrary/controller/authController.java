package com.gxu.informationLibrary.controller;

import com.gxu.informationLibrary.entity.response;
import com.gxu.informationLibrary.entity.roleAuth;
import com.gxu.informationLibrary.serviceImpl.authImpl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Mapper
@ResponseBody
public class authController {
    private final authImpl auth;

    public authController(authImpl auth) {
        this.auth = auth;
    }

    @GetMapping("api/auth/get")
    public response<List<roleAuth>>getAuth(@RequestParam("role_name")String role_name){
        List<roleAuth>data=new ArrayList<>();
        try {
            data=auth.getAuth(role_name);
        }catch (Exception e){
            return new response<>(500,e.getCause().getMessage(),data);
        }
        return new response<>(data);
    }
    @GetMapping("api/auth/name")
    public response<roleAuth>queryByName(@RequestParam("role_name")String role_name){
        roleAuth data=new roleAuth();
        try {
            data=auth.queryByName(role_name);
        }catch (Exception e){
            return new response<>(500,e.getCause().getMessage(),data);
        }
        return new response<>(data);
    }

    @PostMapping("api/auth/edit")
    public response<List<roleAuth>>editAuth(@RequestBody String param){
        List<roleAuth>data=new ArrayList<>();
        try {
            data=auth.editAuth(param);
        }catch (Exception e){
            return new response<>(500,e.getCause().getMessage(),data);
        }
        return new response<>(data);
    }
}
