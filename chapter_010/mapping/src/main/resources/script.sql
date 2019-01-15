CREATE DATABASE carstore;

-- TABLES:

-- Images:
CREATE TABLE images (
    id serial PRIMARY KEY,
    url VARCHAR(255) NOT NULL
);

-- Wheel drives:
CREATE TABLE wheeldrives (
    id serial PRIMARY KEY,
    type VARCHAR(255) NOT NULL UNIQUE
);

-- Brands:
CREATE TABLE brands (
    id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

-- Transmissions:
CREATE TABLE transmissions (
    id serial PRIMARY KEY,
    type VARCHAR(255) NOT NULL UNIQUE
);

-- Bodies:
CREATE TABLE bodystyles (
    id serial PRIMARY KEY,
    body VARCHAR(255) NOT NULL UNIQUE
);

-- Users:
CREATE TABLE users (
    id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(255) NOT NULL UNIQUE,
    url VARCHAR(255) NOT NULL UNIQUE
);

-- Models:
CREATE TABLE models (
    id serial PRIMARY KEY,
    id_brand INTEGER REFERENCES brands(id) NOT NULL,
    model VARCHAR(255) NOT NULL UNIQUE
);

-- Engines:
CREATE TABLE engines (
    id serial PRIMARY KEY,
    id_brand INTEGER REFERENCES brands(id) NOT NULL,
    id_model INTEGER REFERENCES models(id) NOT NULL,
    type VARCHAR(255) NOT NULL,
    capacity numeric NOT NULL
);

-- Cars:
CREATE TABLE cars (
    id serial PRIMARY KEY,
    id_brand INTEGER REFERENCES brands(id) NOT NULL,
    id_model INTEGER REFERENCES models(id) NOT NULL,
    id_bodystyle INTEGER REFERENCES bodystyles(id) NOT NULL,
    id_engine INTEGER REFERENCES engines(id) NOT NULL,
    id_transmission INTEGER REFERENCES transmissions(id) NOT NULL,
    id_wheeldrive INTEGER REFERENCES wheeldrives(id) NOT NULL,
    horsepowers INTEGER,
    productionYear INTEGER,
    mileage INTEGER,
    color VARCHAR(255)NOT NULL
);

-- Advertisements:
CREATE TABLE advertisements (
     id serial PRIMARY KEY,
   	 id_user INTEGER REFERENCES users(id) NOT NULL,
     id_car INTEGER REFERENCES cars(id) NOT NULL,
     id_image INTEGER REFERENCES images(id) NOT NULL,
     description VARCHAR(255),
     sold BOOLEAN,
     price NUMERIC,
     create_date TIMESTAMP
);

-- Queries to fill up several tables:

-- Data for wheeldrives:
INSERT INTO wheeldrives(type) VALUES ('front-wheel');
INSERT INTO wheeldrives(type) VALUES ('four-wheel');
INSERT INTO wheeldrives(type) VALUES ('rear-wheel');

-- Data for transmissions:
INSERT INTO transmissions(type) VALUES ('manual');
INSERT INTO transmissions(type) VALUES ('automatic');
INSERT INTO transmissions(type) VALUES ('CVT');
INSERT INTO transmissions(type) VALUES ('semi-automatic');
INSERT INTO transmissions(type) VALUES ('dual-clutch');
INSERT INTO transmissions(type) VALUES ('DSG');
INSERT INTO transmissions(type) VALUES ('Tip-Tronic');

-- Data for brands:
INSERT INTO brands(name) VALUES('Lada');
INSERT INTO brands(name) VALUES('Ford');
INSERT INTO brands(name) VALUES('Skoda');
INSERT INTO brands(name) VALUES('Audi');
INSERT INTO brands(name) VALUES('BMW');
INSERT INTO brands(name) VALUES('Chevrolet');
INSERT INTO brands(name) VALUES('Honda');
INSERT INTO brands(name) VALUES('Geely');
INSERT INTO brands(name) VALUES('KIA');
INSERT INTO brands(name) VALUES('Opel');
INSERT INTO brands(name) VALUES('Mazda');
INSERT INTO brands(name) VALUES('Nissan');
INSERT INTO brands(name) VALUES('Hyundai');
INSERT INTO brands(name) VALUES('Peugeot');
INSERT INTO brands(name) VALUES('MINI');
INSERT INTO brands(name) VALUES('Lexus');
INSERT INTO brands(name) VALUES('Volvo');
INSERT INTO brands(name) VALUES('Subaru');
INSERT INTO brands(name) VALUES('Mercedes-Benz');
INSERT INTO brands(name) VALUES('Toyota');

-- Data for bodies:
INSERT INTO bodystyles (body) VALUES('hatchback');
INSERT INTO bodystyles (body) VALUES('coupe');
INSERT INTO bodystyles (body) VALUES('sedan');
INSERT INTO bodystyles (body) VALUES('Mini-MPV');
INSERT INTO bodystyles (body) VALUES('MPV');
INSERT INTO bodystyles (body) VALUES('saloon');
INSERT INTO bodystyles (body) VALUES('liftback');
INSERT INTO bodystyles (body) VALUES('estate');
INSERT INTO bodystyles (body) VALUES('crossover');
INSERT INTO bodystyles (body) VALUES('roadster');
INSERT INTO bodystyles (body) VALUES('SUV');
INSERT INTO bodystyles (body) VALUES('4x4 off-road');

-- Data for models:
INSERT INTO models (id_brand, model) VALUES(1, 'Vesta');
INSERT INTO models (id_brand, model) VALUES(2, 'Focus');
INSERT INTO models (id_brand, model) VALUES(3, 'Rapid');
INSERT INTO models (id_brand, model) VALUES(4, 'A3');
INSERT INTO models (id_brand, model) VALUES(5, 'I8');
INSERT INTO models (id_brand, model) VALUES(6, 'Camaro');
INSERT INTO models (id_brand, model) VALUES(7, 'Civic');
INSERT INTO models (id_brand, model) VALUES(8, 'Emgrand');
INSERT INTO models (id_brand, model) VALUES(9, 'Rio');
INSERT INTO models (id_brand, model) VALUES(10, 'Astra');
INSERT INTO models (id_brand, model) VALUES(11, 'CX-5');
INSERT INTO models (id_brand, model) VALUES(12, 'Almera');
INSERT INTO models (id_brand, model) VALUES(13, 'Solaris');
INSERT INTO models (id_brand, model) VALUES(14, '408');
INSERT INTO models (id_brand, model) VALUES(15, 'Cooper');
INSERT INTO models (id_brand, model) VALUES(16, 'RC');
INSERT INTO models (id_brand, model) VALUES(17, 'S60');
INSERT INTO models (id_brand, model) VALUES(18, 'Forester');
INSERT INTO models (id_brand, model) VALUES(19, 'GLE 63 AMG Coupe');
INSERT INTO models (id_brand, model) VALUES(20, 'Corolla');

-- Data for engines:
INSERT INTO engines (id_brand, id_model, type, capacity) VALUES(1, 1, 'petrol', 1.6);
INSERT INTO engines (id_brand, id_model, type, capacity) VALUES(2, 2, 'diesel', 2.0);
INSERT INTO engines (id_brand, id_model, type, capacity) VALUES(3, 3, 'petrol', 1.6);
INSERT INTO engines (id_brand, id_model, type, capacity) VALUES(4, 4, 'petrol', 1.4);
INSERT INTO engines (id_brand, id_model, type, capacity) VALUES(5, 5, 'hybrid', 1.5);
INSERT INTO engines (id_brand, id_model, type, capacity) VALUES(6, 6, 'petrol', 3.8);

-- Data for images:
INSERT INTO images (url) VALUES('../images/vesta.jpg');
INSERT INTO images (url) VALUES('../images/ford%20focus.png');
INSERT INTO images (url) VALUES('../images/rapid.jpg');
INSERT INTO images (url) VALUES('../images/audi%20a3.jpg');
INSERT INTO images (url) VALUES('../images/bmw%20i8.jpg');
INSERT INTO images (url) VALUES('../images/chevrolet%20camaro.jpg');
INSERT INTO images (url) VALUES('../images/honda%20civic.jpg');
INSERT INTO images (url) VALUES('../images/geely%20emgrand.jpg');

-- Data for users:
INSERT INTO users (name, password, email, phone, url) VALUES ('Evgeny', 'e', 'evgeny.hodz@gmail.com', '89876543210', 'https://vk.com/alittlemind');

-- Data for cars:
INSERT INTO cars (id_brand, id_model, id_bodystyle, id_engine, id_transmission, id_wheeldrive, horsepowers, productionYear, mileage, color) VALUES (1, 1, 3, 1, 1, 1, 106, 2017, 15, 'Green');
INSERT INTO cars (id_brand, id_model, id_bodystyle, id_engine, id_transmission, id_wheeldrive, horsepowers, productionYear, mileage, color) VALUES (2, 2, 1, 2, 2, 1, 120, 2015, 35200, 'Orange');
INSERT INTO cars (id_brand, id_model, id_bodystyle, id_engine, id_transmission, id_wheeldrive, horsepowers, productionYear, mileage, color) VALUES (3, 3, 7, 1, 1, 1, 90, 2017, 10, 'Grey');
INSERT INTO cars (id_brand, id_model, id_bodystyle, id_engine, id_transmission, id_wheeldrive, horsepowers, productionYear, mileage, color) VALUES (4, 4, 3, 4, 7, 2, 180, 2016, 2120, 'Black');
INSERT INTO cars (id_brand, id_model, id_bodystyle, id_engine, id_transmission, id_wheeldrive, horsepowers, productionYear, mileage, color) VALUES (5, 5, 2, 5, 2, 3, 362, 2017, 132, 'Blue');
INSERT INTO cars (id_brand, id_model, id_bodystyle, id_engine, id_transmission, id_wheeldrive, horsepowers, productionYear, mileage, color) VALUES (6, 6, 2, 6, 1, 3, 238, 2014, 5600, 'Yellow');
INSERT INTO cars (id_brand, id_model, id_bodystyle, id_engine, id_transmission, id_wheeldrive, horsepowers, productionYear, mileage, color) VALUES (7, 7, 2, 3, 2, 1, 175, 2017, 11, 'Red');
INSERT INTO cars (id_brand, id_model, id_bodystyle, id_engine, id_transmission, id_wheeldrive, horsepowers, productionYear, mileage, color) VALUES (8, 8, 3, 1, 4, 2, 98, 2017, 3, 'White');

-- Data for advertisements:
INSERT INTO advertisements (id_user, id_car, id_image, description, sold, price, create_date) VALUES (1, 1, 1, 'LADA Vesta. Russian GC', false, 715000, null);
INSERT INTO advertisements (id_user, id_car, id_image, description, sold, price, create_date) VALUES (1, 2, 2, 'Ford Focus. American dream', false, 1200000, null);
INSERT INTO advertisements (id_user, id_car, id_image, description, sold, price, create_date) VALUES (1, 3, 3, 'Skoda Rapid. Simply clever', false, 785400, null);
INSERT INTO advertisements (id_user, id_car, id_image, description, sold, price, create_date) VALUES (1, 4, 4, 'Audi A3. German perfection', false, 1800000, null);








