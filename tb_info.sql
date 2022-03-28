create table tb_info
(
    tb_id   int auto_increment primary key,
    db_name varchar(64) not null,
    tb_name varchar(64) not null,
    foreign key (db_name) references db_info(db_name)
);


