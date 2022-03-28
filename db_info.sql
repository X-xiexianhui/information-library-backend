create table db_info
(
    db_id   int auto_increment primary key,
    db_name varchar(64)   not null unique ,
    tables  int default 0 null
);


