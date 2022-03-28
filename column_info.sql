create table column_info
(
    col_id    int auto_increment primary key ,
    tb_name   varchar(64)          not null,
    col_name  varchar(64)          not null,
    data_type varchar(64)          not null,
    len       int                  not null,
    place     int                  null,
    PK        tinyint(1) default 0 null,
    not_null  tinyint(1) default 0 null,
    uni       tinyint(1) default 0 null,
    constraint tb_name_tb_info_tb_name foreign key(tb_name) references tb_info(tb_name)

);


