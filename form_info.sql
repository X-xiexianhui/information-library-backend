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


