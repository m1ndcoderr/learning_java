CREATE DATABASE Appl_System;

CREATE TABLE roles (
    role_id SERIAL PRIMARY KEY,
    role CHARACTER VARYING(10)
);

CREATE TABLE rights (
    right_id SERIAL PRIMARY KEY,
    right_name CHARACTER VARYING(10),
    role_id INTEGER REFERENCES roles (role_id)
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    user CHARACTER VARYING(10),
    role_id INTEGER REFERENCES roles (role_id)
);

CREATE TABLE categories (
    category_id SERIAL PRIMARY KEY,
    category CHARACTER VARYING(10)
);

CREATE TABLE conditions (
    condition_id SERIAL PRIMARY KEY,
    cond CHARACTER VARYING(10)
);

CREATE TABLE applications (
    application_id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES users (user_id),
    category_id INTEGER REFERENCES categories (category_id),
    condition_id INTEGER REFERENCES conditions (condition_id)
);

CREATE TABLE comments (
    comment_id SERIAL PRIMARY KEY,
    comment_text CHARACTER VARYING(1000),
    application_id INTEGER REFERENCES applications (application_id)
);

CREATE TABLE attached_files (
    file_id SERIAL PRIMARY KEY,
    file_path CHARACTER VARYING(1000),
    application_id INTEGER REFERENCES applications (application_id)
);

INSERT INTO roles(role) VALUES ('admin');
INSERT INTO rights(right_name, role_id) VALUES ('full_rights', 1);
INSERT INTO users(user, role_id) VALUES ('Evgeny', 1);
INSERT INTO categories(category) VALUES ('First');
INSERT INTO conditions(cond) VALUES ('unchecked');
INSERT INTO applications(user_id, category_id, condition_id)VALUES (1, 1, 1);
INSERT INTO comments(comment_text, application_id) VALUES ('some comment', 1);
INSERT INTO attached_files(file_path, application_id) VALUES ('c\:', 1);