create table back_up
(
    id           varchar(32) not null
        primary key,
    created_time datetime(6) null,
    updated_time datetime(6) null
);

create table uuid
(
    next_val bigint null
);

create table work_out
(
    id           varchar(32)    not null
        primary key,
    duration     double         null,
    position     int default -1 null,
    title        varchar(64)    null,
    version      int            null,
    backup_id    varchar(32)    null,
    created_time datetime(6)    null,
    updated_time datetime(6)    null,
    constraint FKhsipjnd5icb5g50o8buctb7hn
        foreign key (backup_id) references back_up (id)
);

create table event
(
    id           varchar(32)   not null
        primary key,
    duration     double        null,
    repetitions  int default 1 null,
    event_id     varchar(32)   null,
    created_time datetime(6)   null,
    updated_time datetime(6)   null,
    constraint FK2twa5w6nenhnirimkoy4w0kp5
        foreign key (event_id) references work_out (id)
);

create table exercise
(
    id           varchar(32)                     not null
        primary key,
    duration     int          default 30         null,
    name         varchar(100) default 'exercise' not null,
    exercise_id  varchar(32)                     null,
    created_time datetime(6)                     null,
    updated_time datetime(6)                     null,
    constraint FKq2mm880u2pn4diwagleghfxxu
        foreign key (exercise_id) references event (id)
);

