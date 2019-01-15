CREATE TABLE engines (
   id serial PRIMARY KEY,
   manufacturer CHARACTER VARYING(30),
   type CHARACTER VARYING(20),
   appointment CHARACTER VARYING (10),
   price INTEGER
);

CREATE TABLE transmissions (
   id serial PRIMARY KEY,
   manufacturer CHARACTER VARYING (30),
   type CHARACTER VARYING (20),
   price INTEGER
);

CREATE TABLE gearboxes (
   id serial PRIMARY KEY,
   manufacturer CHARACTER VARYING (30),
   type CHARACTER VARYING (20),
   price INTEGER
);

CREATE TABLE machines (
   id serial PRIMARY KEY,
   manufacturer CHARACTER VARYING (30),
   trans_id INTEGER REFERENCES transmissions(id),
   gb_id INTEGER REFERENCES gearboxes(id),
   en_id INTEGER REFERENCES engines(id)
);

INSERT INTO engines (manufacturer, type, appointment, price) VALUES ('Tesla', 'electric', 'Model 3', 1000);
INSERT INTO engines (manufacturer, type, appointment, price) VALUES  ('BMW', 'diesel', 'BMW X5', 2000);

INSERT INTO transmissions (manufacturer, type, price) VALUES ('Tesla', '1-speed fixed gear', 1200);
INSERT INTO transmissions (manufacturer, type, price) VALUES ('BMW', '5-speed automatic', 1500);

INSERT INTO gearboxes(manufacturer, type, price) VALUES ('BMW', 'automatic', 500);

INSERT INTO machines(manufacturer, trans_id, en_id) VALUES ('Tesla', 1, 1);
INSERT INTO machines(manufacturer, trans_id, gb_id, en_id) VALUES ('BMW', 2, 2, 2);

