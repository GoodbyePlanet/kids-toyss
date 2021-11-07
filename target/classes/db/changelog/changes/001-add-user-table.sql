CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS "user"
(
    id uuid DEFAULT uuid_generate_v4(),
    name  varchar(50)  not null,
    email varchar(255)  not null,
    primary key (id)
);