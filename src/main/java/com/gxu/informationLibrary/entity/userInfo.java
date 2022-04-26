package com.gxu.informationLibrary.entity;

import lombok.Data;

@Data
public class userInfo {
    String user_id;
    String user_name;
    String user_pwd;
    String user_email;
    String user_role;
    boolean disabled;
}
