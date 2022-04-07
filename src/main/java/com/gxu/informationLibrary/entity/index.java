package com.gxu.informationLibrary.entity;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Getter
@Setter
public class index {
    List<String>fields;
    Boolean uni;

    public index(List<String> fields, Boolean uni) {
        this.fields = fields;
        this.uni = uni;
    }

    public index(@NotNull String fields, Boolean uni) {
        this.fields=Arrays.asList(fields.split(","));
        this.uni = uni;
    }
}
