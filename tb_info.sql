create table tb_info
(
    tb_id   int auto_increment primary key,
    db_name varchar(64) not null,
    tb_name varchar(64) not null,
    constraint tb_info_tb_name_db_info_db_name foreign key (db_name) references db_info(db_name)
);


