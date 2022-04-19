package com.gxu.informationLibrary.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
        int menu_id=JSON.parseObject(param).getIntValue("menu_id");
        menu.deleteMenu(menu_id);
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
        JSONObject menuJSON=JSON.parseObject(param);
        menu.editMenu(menuJSON.getString("col_name"), menuJSON.getString("value"));
        return menu.query("");
    }
}
