package com.gxu.informationLibrary.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.gxu.informationLibrary.dao.menuDao;
import com.gxu.informationLibrary.entity.menuInfo;
import com.gxu.informationLibrary.server.menuServer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class menuImpl implements menuServer {
    final menuDao menu;

    public menuImpl(menuDao menu) {
        this.menu = menu;
    }

    @Override
    public List<menuInfo> addMenu(String param) {
        menuInfo menuObject=JSON.parseObject(param).toJavaObject(menuInfo.class);
        menu.addMenu(menuObject);
        return menu.query("");
    }

    @Override
    public List<menuInfo> deleteMenu(String param) {
        menu.deleteMenu();
        return menu.query("");
    }

    @Override
    public List<menuInfo> queryMenu(String menu_name) {
        return menu.query(menu_name);
    }

    public menuInfo queryMenu(int menu_id) {
        return menu.getMenuById(menu_id);
    }

    public List<Map<String, Object>> queryMenu() {
        return menu.getMenuSelect();
    }

    @Override
    public List<menuInfo> editMenu(String param) {
        menu.editMenu();
        return menu.query("");
    }

    public List<Map<String, Object>> getFormSelect() {
        return menu.getFormSelect();
    }
}
