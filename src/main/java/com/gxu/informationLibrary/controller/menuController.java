package com.gxu.informationLibrary.controller;

import com.gxu.informationLibrary.entity.menuInfo;
import com.gxu.informationLibrary.entity.response;
import com.gxu.informationLibrary.serviceImpl.menuImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class menuController {
    final menuImpl menu;

    public menuController(menuImpl menu) {
        this.menu = menu;
    }
    @PostMapping("api/menu/add")
    public response<List<menuInfo>>addMenu(@RequestBody String Param){
        List<menuInfo>data=new ArrayList<>();
        try {
            data=menu.addMenu(Param);
        }catch (Exception e){
            return new response<>(500,e.getCause().getMessage(),data);
        }
        return new response<>(data);
    }
    @PostMapping("api/menu/delete")
    public response<List<menuInfo>>deleteMenu(@RequestBody String Param){
        List<menuInfo>data=new ArrayList<>();
        try {
            data=menu.deleteMenu(Param);
        }catch (Exception e){
            return new response<>(500,e.getCause().getMessage(),data);
        }
        return new response<>(data);
    }
    @GetMapping("api/menu/query")
    public response<List<menuInfo>>query(@RequestParam("menu_name") String menu_name){
        List<menuInfo>data=new ArrayList<>();
        try {
            data=menu.queryMenu(menu_name);
        }catch (Exception e){
            return new response<>(500,e.getCause().getMessage(),data);
        }
        return new response<>(data);
    }
    @PostMapping("api/menu/edit")
    public response<List<menuInfo>>editMenu(@RequestBody String param){
        List<menuInfo>data=new ArrayList<>();
        try {
            data=menu.editMenu(param);
        }catch (Exception e){
            return new response<>(500,e.getCause().getMessage(),data);
        }
        return new response<>(data);
    }
    @GetMapping("api/menu/select")
    public response<List<Map<String,Object>>>getMenuSelect(){
        List<Map<String,Object>>data=new ArrayList<>();
        try {
            data=menu.queryMenu();
        }catch (Exception e){
            return new response<>(500,e.getCause().getMessage(),data);
        }
        return new response<>(data);
    }
    @GetMapping("api/menu/form")
    public response<List<Map<String,Object>>>getFormSelect(){
        List<Map<String,Object>>data=new ArrayList<>();
        try {
            data=menu.getFormSelect();
        }catch (Exception e){
            return new response<>(500,e.getCause().getMessage(),data);
        }
        return new response<>(data);
    }
    @GetMapping("api/menu/id")
    public response<menuInfo>getMenu(@RequestParam("form_id") int menu_id){
        menuInfo data=new menuInfo();
        try {
            data=menu.queryMenu(menu_id);
        }catch (Exception e){
            return new response<>(500,e.getCause().getMessage(),data);
        }
        return new response<>(data);
    }
}
