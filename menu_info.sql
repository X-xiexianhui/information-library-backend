create table menu_info
(
    menu_id      int auto_increment
        primary key,
    menu_name    varchar(64) not null,
    menu_level   char(4)     not null,
    father_menu  int         null,
    context_form int         null,
    constraint menu_info_menu_name_uindex
        unique (menu_name),
    constraint menu_info_menu_info_menu_id_fk
        foreign key (father_menu) references menu_info (menu_id)
);


