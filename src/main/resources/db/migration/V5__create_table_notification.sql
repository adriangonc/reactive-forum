create table TB_NOTIFICATION(
    id varchar(500) not null,
    creation_date datetime not null,
    notification_body json not null,
    notification_source varchar(500),
    id_payment varchar(500),
    status_payment varchar(500),
    primary key(id)
);