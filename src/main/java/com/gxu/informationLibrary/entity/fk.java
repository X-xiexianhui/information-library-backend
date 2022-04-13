package com.gxu.informationLibrary.entity;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class fk {
    String fk_name;
    String fk_column;
    String ref_table;
    String ref_column;
}
