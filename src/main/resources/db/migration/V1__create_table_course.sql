create table TB_COURSE(
    id identity not null,
    name varchar(200),
    category varchar(100),
    primary key(id)
);

insert into TB_COURSE values(1, 'Default Course', 'Programing')