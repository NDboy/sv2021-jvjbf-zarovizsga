
alter table players
    add constraint FK_TeamPlayer foreign key (team_id) references teams (id)