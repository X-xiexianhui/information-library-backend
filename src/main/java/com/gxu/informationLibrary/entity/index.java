package com.gxu.informationLibrary.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class index {
    String index_name;
    List<String>fields;
    boolean uni;

    public index(String index_name,List<String> fields, Boolean uni) {
        this.index_name=index_name;
        this.fields = fields;
        this.uni = uni;
    }
    public index(){}
}