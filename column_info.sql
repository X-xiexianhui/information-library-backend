create table column_info
(
    col_id    int auto_increment primary key ,
    tb_id     int not null ,
    col_name  varchar(64)          not null,
    data_type varchar(64)          not null,
    len       int                  not null,
    place     int                  null,
    PK        tinyint(1) default 0 null,
    not_null  tinyint(1) default 0 null,
    uni       tinyint(1) default 0 null,
    constraint column_info_tb_id_tb_info_tb_name foreign key(tb_id) references tb_info(tb_id) on DELETE cascade on update cascade
);


