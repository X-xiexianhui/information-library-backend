package com.gxu.informationLibrary.entity;

import lombok.Data;

import java.util.List;

@Data
public class initMenu {
    String name;
    List<childMenu>child;
}
