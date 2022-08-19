create table TB_USER(
    id identity not null,
    name varchar(100),
    email varchar(100),
    password varchar(500),
    primary key(id)
);

insert into TB_USER values(1, 'Adriano', 'adriano@tete.com', '$2a$12$mUNgqd2Slq/0wv7GtLMTxOHGHu.qyOArm6DEPi4Q/F13h61xT6A1e')