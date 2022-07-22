create table TB_ANSWERS(
    id identity not null,
    message varchar(100) not null,
    creationDate datetime not null,
    author_id bigint not null,
    topic_id bigint not null,
    solution integer not null,
    primary key(id),
    foreign key(author_id) references TB_USER(id),
    foreign key(topic_id) references TB_TOPIC(id)
);