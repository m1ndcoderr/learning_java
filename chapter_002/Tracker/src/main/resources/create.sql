CREATE DATABASE tracker_data;

CREATE TABLE applications (
    app_id serial PRIMARY KEY,
    name VARCHAR(100),
    description TEXT,
    create_date TIMESTAMP
);

CREATE TABLE comments (
    comm_id serial PRIMARY KEY,
    comm  TEXT,
    app_id INTEGER REFERENCES applications(app_id)
);