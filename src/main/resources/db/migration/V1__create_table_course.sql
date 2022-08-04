create table TB_COURSE(
    id identity not null,
    name varchar(200),
    category varchar(100),
    primary key(id)
);

insert into TB_COURSE values(-1, 'Default Course', 'Programing');
insert into TB_COURSE values(-2, 'C++', 'Programing');
insert into TB_COURSE values(-3, 'Java', 'Programing');
insert into TB_COURSE values(-4, 'Python', 'Data science');
insert into TB_COURSE values(-5, 'Kotlin', 'Programing');