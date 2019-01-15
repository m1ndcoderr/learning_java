CREATE DATABASE ads;

CREATE TABLE ads (
    add_id serial PRIMARY KEY,
    title TEXT,
    description TEXT,
    create_date VARCHAR (10)
);