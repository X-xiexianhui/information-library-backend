package com.gxu.informationLibrary.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class dbInfo {
    private int db_id;
    private String db_name;
    private int tables;

    public dbInfo(int db_id, String db_name, int tables) {
        this.db_id = db_id;
        this.db_name = db_name;
        this.tables = tables;
    }
}
