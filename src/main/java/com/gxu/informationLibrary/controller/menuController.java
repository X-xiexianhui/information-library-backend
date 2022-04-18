package com.gxu.informationLibrary.controller;

import com.gxu.informationLibrary.serviceImpl.menuImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class menuController {
    final menuImpl menu;

    public menuController(menuImpl menu) {
        this.menu = menu;
    }
}
