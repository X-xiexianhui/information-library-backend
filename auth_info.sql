create table auth_info
(
    auth_level varchar(2)  not null
        primary key,
    `option`   varchar(2)  not null,
    auth_mean  varchar(20) not null,
    constraint auth_info_auth_level_uindex
        unique (auth_level)
);


