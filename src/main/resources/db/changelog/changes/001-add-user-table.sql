CREATE TABLE IF NOT EXISTS "user"
(
    id uuid NOT NULL,
    name  varchar(50)  NOT NULL,
    email varchar(255)  NOT NULL,
    primary key (id)
);