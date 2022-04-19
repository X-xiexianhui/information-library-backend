create table role_info
(
    role_id          int auto_increment
        primary key,
    role_name        varchar(64) not null,
    role_description text        null,
    constraint role_info_role_name_uindex
        unique (role_name)
);


