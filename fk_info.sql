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


