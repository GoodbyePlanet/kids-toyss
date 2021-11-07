CREATE TABLE IF NOT EXISTS "user"
(
    id    bigserial not null,
    name  varchar(50)  not null,
    email varchar(255)  not null,
    primary key (id)
);