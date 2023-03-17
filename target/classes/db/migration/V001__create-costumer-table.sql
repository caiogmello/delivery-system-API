CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(60) NOT NULL,
    email varchar(255) NOT NULL,
    phone varchar(20) NOT NULL
);