create table TB_TOPIC(
    id identity not null,
    title varchar(150) not null,
    message varchar(2000) not null,
    creation_date datetime not null,
    status varchar(50) not null,
    course_id bigint not null,
    author_id bigint  not null,
    primary key(id),
    foreign key(course_id) references TB_COURSE(id),
    foreign key(author_id) references TB_USER(id)
);