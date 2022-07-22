create table TB_USER(
    id identity not null,
    name varchar(100),
    email varchar(100),
    primary key(id)
);

insert into TB_USER values(1, 'Adriano', 'adriano@tete.com')