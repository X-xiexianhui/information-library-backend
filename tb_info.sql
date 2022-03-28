create table tb_info
(
    tb_id   int auto_increment
        primary key,
    db      int         not null,
    tb_name varchar(64) not null,
    constraint tb_info_db_info_db_id_fk
        foreign key (db) references db_info (db_id)
            on update cascade on delete cascade
);


