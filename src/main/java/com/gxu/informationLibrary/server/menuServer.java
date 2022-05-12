package com.gxu.informationLibrary.server;

import com.gxu.informationLibrary.entity.menuInfo;
import com.gxu.informationLibrary.entity.response;

import java.util.List;

public interface menuServer {
    List<menuInfo>addMenu(String param);

    response<List<menuInfo>>deleteMenu(String param);

    List<menuInfo>queryMenu(String menu_name);

    response<List<menuInfo>> editMenu(String param);
}
