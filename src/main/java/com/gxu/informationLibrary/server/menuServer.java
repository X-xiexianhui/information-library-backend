package com.gxu.informationLibrary.server;

import com.gxu.informationLibrary.entity.menuInfo;

import java.util.List;

public interface menuServer {
    List<menuInfo>addMenu(String param);

    List<menuInfo>deleteMenu(String param);

    List<menuInfo>queryMenu(String menu_name);

    List<menuInfo>editMenu();
}
