package com.gxu.informationLibrary.entity;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
@Getter
@Setter
public class index {
    int index_id;
    String db_name;
    String tb_name;
    List<String>fields;
    boolean uni;

    public index(String db_name,String tb_name,List<String> fields, Boolean uni) {
        this.db_name=db_name;
        this.tb_name=tb_name;
        this.fields = fields;
        this.uni = uni;
    }
    public index(int index_id,String db_name,String tb_name,List<String> fields, Boolean uni) {
        this.index_id=index_id;
        this.db_name=db_name;
        this.tb_name=tb_name;
        this.fields = fields;
        this.uni = uni;
    }
    public index(int index_id,String db_ame,String tb_name,@NotNull String fields, Boolean uni) {
        this.index_id=index_id;
        this.db_name=db_ame;
        this.tb_name=tb_name;
        this.fields=Arrays.asList(fields.split(","));
        this.uni = uni;
    }
}