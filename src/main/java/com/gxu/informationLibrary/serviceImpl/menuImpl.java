package com.gxu.informationLibrary.serviceImpl;

import com.gxu.informationLibrary.dao.menuDao;
import com.gxu.informationLibrary.entity.menuInfo;
import com.gxu.informationLibrary.server.menuServer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor=Exception.class)
public class menuImpl implements menuServer {
    final menuDao menu;

    public menuImpl(menuDao menu) {
        this.menu = menu;
    }

    @Override
    public List<menuInfo> addMenu() {
        menu.addMenu();
        return menu.query("");
    }

    @Override
    public List<menuInfo> deleteMenu() {
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

    public List<Map<String,Object>> queryMenu() {
        return menu.getMenuSelect();
    }

    @Override
    public List<menuInfo> editMenu() {
        return null;
    }
}
