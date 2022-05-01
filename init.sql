create table auth_info
(
    auth_level char(2)     not null
        primary key,
    `option`   varchar(2)  not null,
    auth_mean  varchar(20) not null,
    constraint auth_info_auth_level_uindex
        unique (auth_level)
);

create table db_info
(
    db_id   int auto_increment
        primary key,
    db_name varchar(64)   not null,
    tables  int default 0 null,
    constraint db_name
        unique (db_name)
);

create table menu_info
(
    menu_id      int auto_increment
        primary key,
    menu_name    varchar(64) not null,
    menu_level   char(4)     not null,
    father_menu  int         null,
    context_form int         null,
    constraint menu_info_menu_name_uindex
        unique (menu_name)
);

create index menu_info_form_info_form_id_fk
    on menu_info (context_form);

create index menu_info_menu_info_menu_id_fk
    on menu_info (father_menu);

create table role_info
(
    role_id          int auto_increment
        primary key,
    role_name        varchar(64) not null,
    role_description text        null,
    constraint role_info_role_name_uindex
        unique (role_name)
);

create table tb_info
(
    tb_id   int auto_increment
        primary key,
    db_name varchar(64) not null,
    tb_name varchar(64) not null,
    constraint db_name_fk
        foreign key (db_name) references db_info (db_name)
            on update cascade on delete cascade
);

create table column_info
(
    col_id    int auto_increment
        primary key,
    tb_id     int                  not null,
    col_name  varchar(64)          not null,
    data_type varchar(64)          not null,
    len       int                  not null,
    place     int                  null,
    PK        tinyint(1) default 0 null,
    not_null  tinyint(1) default 0 null,
    uni       tinyint(1) default 0 null,
    constraint tb_id_fk
        foreign key (tb_id) references tb_info (tb_id)
            on update cascade on delete cascade
);

create table fk_info
(
    fk_table   int          not null,
    fk_column  varchar(64)  not null,
    fk_name    varchar(100) not null,
    ref_table  int          not null,
    ref_column varchar(64)  not null,
    primary key (fk_table, fk_column),
    constraint fk_info_FK
        foreign key (fk_table) references tb_info (tb_id)
            on update cascade on delete cascade,
    constraint fk_info_FK_1
        foreign key (ref_table) references tb_info (tb_id)
            on update cascade on delete cascade
);

create table form_info
(
    form_id   int auto_increment
        primary key,
    form_name varchar(64) null,
    tb_id     int         null,
    constraint form_info_form_name_uindex
        unique (form_name),
    constraint form_info_tb_id_uindex
        unique (tb_id),
    constraint form_info_tb_info_tb_id_fk
        foreign key (tb_id) references tb_info (tb_id)
            on update cascade on delete cascade
);

create table form_struct
(
    form_id    int auto_increment,
    col_id     int         not null,
    label_name varchar(64) not null,
    primary key (form_id, col_id),
    constraint form_struct_FK
        foreign key (form_id) references form_info (form_id)
            on update cascade on delete cascade,
    constraint form_struct_FK_1
        foreign key (col_id) references column_info (col_id)
            on update cascade on delete cascade
);

create table index_info
(
    index_name   varchar(64) not null,
    seq_in_index int         not null,
    col_name     varchar(64) not null,
    tb_id        int         not null,
    uni          tinyint(1)  null,
    primary key (index_name, seq_in_index),
    constraint index_info_tb_info_tb_id_fk
        foreign key (tb_id) references tb_info (tb_id)
            on update cascade on delete cascade
);

create table role_auth
(
    role_id  int     not null,
    form_id  int     not null,
    addAuth  char(2) not null,
    del      char(2) not null,
    search   char(2) not null,
    editAuth char(2) not null,
    primary key (role_id, form_id),
    constraint role_auth_FK
        foreign key (addAuth) references auth_info (auth_level)
            on update cascade on delete cascade,
    constraint role_auth_FK_1
        foreign key (del) references auth_info (auth_level)
            on update cascade on delete cascade,
    constraint role_auth_FK_2
        foreign key (search) references auth_info (auth_level)
            on update cascade on delete cascade,
    constraint role_auth_FK_3
        foreign key (editAuth) references auth_info (auth_level)
            on update cascade on delete cascade,
    constraint role_auth_FK_4
        foreign key (role_id) references role_info (role_id)
            on update cascade on delete cascade,
    constraint role_auth_FK_5
        foreign key (form_id) references form_info (form_id)
            on update cascade on delete cascade
);

create table user_info
(
    user_id    varchar(18)       not null
        primary key,
    user_pwd   varchar(32)       not null,
    user_name  varchar(64)       not null,
    user_email varchar(64)       not null,
    user_role  int               not null,
    is_del     tinyint default 0 null,
    constraint user_info_role_info_role_id_fk
        foreign key (user_role) references role_info (role_id)
            on update cascade
);
INSERT INTO information_library.auth_info (auth_level, `option`, auth_mean)
VALUES ('d0', '删除', '不允许删除数据');
INSERT INTO information_library.auth_info (auth_level, `option`, auth_mean)
VALUES ('d1', '删除', '仅允许删除由该用户添加的数据');
INSERT INTO information_library.auth_info (auth_level, `option`, auth_mean)
VALUES ('d2', '删除', '允许删除所有数据');
INSERT INTO information_library.auth_info (auth_level, `option`, auth_mean)
VALUES ('s0', '查询', '仅允许查询由该用户提交的数据');
INSERT INTO information_library.auth_info (auth_level, `option`, auth_mean)
VALUES ('s1', '查询', '允许查询所有数据');
INSERT INTO information_library.auth_info (auth_level, `option`, auth_mean)
VALUES ('u0', '修改', '不允许修改数据');
INSERT INTO information_library.auth_info (auth_level, `option`, auth_mean)
VALUES ('u1', '修改', '仅允许修改由该用户提交的数据');
INSERT INTO information_library.auth_info (auth_level, `option`, auth_mean)
VALUES ('u2', '修改', '允许修改所有数据');
INSERT INTO information_library.auth_info (auth_level, `option`, auth_mean)
VALUES ('w0', '添加', '不允许添加数据');
INSERT INTO information_library.auth_info (auth_level, `option`, auth_mean)
VALUES ('w1', '添加', '允许添加数据');
INSERT INTO information_library.role_info (role_id, role_name, role_description)
VALUES (1, '系统管理员', '系统管理员，可以进入管理后台，拥有对所有数据的全部修改权限，不可删除，不可修改');
INSERT INTO information_library.user_info (user_id, user_pwd, user_name, user_email, user_role, is_del)
VALUES ('admin', '601cea768fb9c2ce3b028391c442e072', '系统管理员', '1281715740@qq.com', 1, 0);



