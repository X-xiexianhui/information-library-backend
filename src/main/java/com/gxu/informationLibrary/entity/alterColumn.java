package com.gxu.informationLibrary.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class alterColumn<T> {
    int col_id;
    String db_name;
    String tb_name;
    String col_name;
    String alter_field;
    T new_Value;

    public alterColumn(int col_id,String db_name, String tb_name, String col_name, T new_Value) {
        this.col_id =col_id;
        this.db_name = db_name;
        this.tb_name = tb_name;
        this.col_name = col_name;
        this.alter_field = alter_field;
        this.new_Value = new_Value;
    }
}
