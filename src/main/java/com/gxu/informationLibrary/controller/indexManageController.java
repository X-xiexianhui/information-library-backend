package com.gxu.informationLibrary.controller;


import com.gxu.informationLibrary.entity.index;
import com.gxu.informationLibrary.entity.response;
import com.gxu.informationLibrary.serviceImpl.indexManageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class indexManageController {
    final indexManageImpl indexManage;

    public indexManageController(indexManageImpl indexManage) {
        this.indexManage = indexManage;
    }

    @PostMapping("/index/edit")
    public response<List<index>> indexManage(String Parma){
        List<index>data=new ArrayList<>();
        try {
            data=indexManage.alterIndex();
        }catch (Exception e) {
            return new response<>(500, e.getCause().getMessage(), data);
        }
        return new response<>(data);
    }
}
