CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS "user"
(
    id uuid DEFAULT uuid_generate_v4()
    name  varchar(50)  NOT NULL,
    email varchar(255)  NOT NULL,
    primary key (id)
);