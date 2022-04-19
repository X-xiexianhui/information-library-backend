create table role_auth
(
    role_id int     not null,
    form_id int     not null,
    `add`   char(2) null,
    del     char(2) null,
    search  char(2) null,
    edit    char(2) null,
    primary key (role_id, form_id),
    constraint role_auth_FK
        foreign key (role_id) references role_info (role_id)
            on update cascade on delete cascade,
    constraint role_auth_FK_1
        foreign key (form_id) references form_info (form_id)
            on update cascade on delete cascade,
    constraint role_auth_FK_2
        foreign key (`add`) references auth_info (auth_level)
            on update cascade on delete cascade,
    constraint role_auth_FK_3
        foreign key (del) references auth_info (auth_level)
            on update cascade on delete cascade,
    constraint role_auth_FK_4
        foreign key (search) references auth_info (auth_level)
            on update cascade on delete cascade,
    constraint role_auth_FK_5
        foreign key (edit) references auth_info (auth_level)
            on update cascade on delete cascade
);


