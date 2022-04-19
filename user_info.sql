create table user_info
(
    user_id    varchar(18) not null
        primary key,
    user_pwd   varchar(32) not null,
    user_name  varchar(64) not null,
    user_email varchar(64) not null,
    user_role  int         not null,
    constraint user_info_role_info_role_id_fk
        foreign key (user_role) references role_info (role_id)
);


