package com.gxu.informationLibrary.util;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class utils {
    public static @NotNull String getIndexName(@NotNull List<String> fields, boolean uni) {
        StringBuilder index_name= new StringBuilder();
        for (String str:fields) {
            index_name.append(str);
            index_name.append("_");
        }
        if (uni){
            index_name.append("uni_index");
        }else {
            index_name.append("index");
        }
        return index_name.toString();
    }
}
