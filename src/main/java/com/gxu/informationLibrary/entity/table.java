package com.gxu.informationLibrary.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class table {
    int tb_id;
    String db_name;
    String tb_name;

    public table(int tb_id, String db_name, String tb_name) {
        this.tb_id = tb_id;
        this.db_name = db_name;
        this.tb_name = tb_name;
    }
}
