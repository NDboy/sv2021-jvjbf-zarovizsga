create table players
(
    id            bigint auto_increment,
    name          varchar(255) not null,
    birth_date    date not null,
    position      varchar(255) not null,
    team_id       bigint,
    primary key (id)
)