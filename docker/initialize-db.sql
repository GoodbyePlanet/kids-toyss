CREATE TABLE IF NOT EXISTS "user" (
    id bigint NOT NULL,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
    );

INSERT INTO "user" (id, name, email) VALUES
(1, 'pero', 'pero@gmail.com'),
(2, 'jovica', 'jovica@gmail.com'),
(3, 'perica', 'perica@gmail.com');

