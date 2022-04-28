package com.gxu.informationLibrary.entity;

import lombok.Data;

@Data
public class response<T> {
    private int code;
    private String msg;
    private T data;

    public response(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public response(T data){
        this.code=200;
        this.msg="success";
        this.data=data;
    }
    public response(){

    }
}
