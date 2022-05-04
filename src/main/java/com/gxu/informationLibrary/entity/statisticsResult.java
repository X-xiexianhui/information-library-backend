package com.gxu.informationLibrary.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class statisticsResult {
    List<Integer>result;
    List<String>col_name;
    public statisticsResult() {
        this.result = new ArrayList<>();
        this.col_name = new ArrayList<>();
    }
}
