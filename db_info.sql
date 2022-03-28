create table db_info
(
    db_id   int auto_increment
        primary key,
    db_name varchar(64)   not null,
    tables  int default 0 null,
    constraint table_name_db_name_uindex
        unique (db_name)
);


