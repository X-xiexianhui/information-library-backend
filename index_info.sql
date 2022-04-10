create table index_info
(
    index_name varchar(64) not null,
    seq_in_index int not null ,
    col_name   varchar(64) not null,
    tb_id      int         not null,
    uni        tinyint(1)  null,
    primary key (index_name,seq_in_index),
    constraint index_info_tb_info_tb_id_fk
        foreign key (tb_id) references tb_info (tb_id)
);


