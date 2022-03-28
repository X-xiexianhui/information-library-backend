create table tb_info
(
    tb_id   int auto_increment primary key,
    db_name varchar(64) not null,
    tb_name varchar(64) not null,
    constraint db_name_fk foreign key (db_name) references db_info(db_name)
);


