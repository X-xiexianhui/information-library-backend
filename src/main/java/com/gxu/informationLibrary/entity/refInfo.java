package com.gxu.informationLibrary.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class refInfo {
    List<String>ref_table;
    List<Map<String,String>>ref_column;
}
