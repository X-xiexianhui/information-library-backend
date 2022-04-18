create table form_struct
(
    form_id    int auto_increment,
    col_id     int         not null,
    label_name varchar(64) not null,
    primary key (form_id, col_id),
    constraint form_struct_FK
        foreign key (form_id) references form_info (form_id)
            on update cascade on delete cascade,
    constraint form_struct_FK_1
        foreign key (col_id) references column_info (col_id)
            on update cascade on delete cascade
);


