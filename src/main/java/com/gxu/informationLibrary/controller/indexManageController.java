package com.gxu.informationLibrary.controller;

import com.alibaba.fastjson.JSONObject;
import com.gxu.informationLibrary.entity.response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class indexManageController {
    @PostMapping("/index/edit")
    public response<List<JSONObject>> indexManage(String Parma){
        List<JSONObject>data=new ArrayList<>();
        return new response<>(data);
    }
}
