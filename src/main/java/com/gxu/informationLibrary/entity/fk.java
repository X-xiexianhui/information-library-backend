package com.gxu.informationLibrary.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class fk {
    int fk_table;
    String fk_column;
    String fk_name;
    int ref_table;
    String ref_column;
}
