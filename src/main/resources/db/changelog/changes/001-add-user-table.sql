CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS "user"
(
    id bigserial NOT NULL,
    name  VARCHAR(50)  NOT NULL,
    email VARCHAR(255)  NOT NULL,
    PRIMARY KEY (id)
);