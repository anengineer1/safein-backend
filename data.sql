CREATE TABLE IF NOT EXISTS cities (
id INT NOT NULL AUTO_INCREMENT,
location POINT NOT NULL,
name VARCHAR(255) NOT NULL,
id_country VARCHAR(2),
PRIMARY KEY (id),
CONSTRAINT country_fk FOREIGN KEY (id_country) REFERENCES country (country_code)
);

LOCK TABLES cities WRITE;
-- POINT(latitude, longitude)
INSERT INTO cities (location, name, id_country) VALUES (ST_GeomFromText('POINT(37.7749 -122.4194)'), 'Kirtze', 'UA');
INSERT INTO cities (location, name, id_country) VALUES (ST_GeomFromText('POINT(37.7749 -12.4194)'), 'Uowe', 'SO');
INSERT INTO cities (location, name, id_country) VALUES (ST_GeomFromText('POINT(38.7749 -122.4194)'), 'Roj', 'ID');
UNLOCK TABLES;

CREATE TABLE IF NOT EXISTS  hotels (
id INT NOT NULL AUTO_INCREMENT,
phonenumber VARCHAR(20) NOT NULL,
email VARCHAR(255) NOT NULL,
address VARCHAR(255) NOT NULL,
location POINT NOT NULL,
security_level ENUM('Diplomatic coverage and private security', 'Private security', 'Diplomatic coverage'),
enery_sucicient BOOLEAN,
id_city INT,
PRIMARY KEY (id),
CONSTRAINT city_fk FOREIGN KEY (id_city) REFERENCES city (id)
);

LOCK TABLES hotels WRITE;
INSERT INTO hotels (phonenumber, email, address, location, security_level, enery_sucicient, id_city) VALUES
('+34555555555', 'reboca@gmail.com', 'Arbeitzer street 5', ST_GeomFromText('POINT(37.7749 -122.4194)'), 'Diplomatic coverage and private security', true, 1),
('+34777777777', 'redestro@gmail.com', 'Uburubao street 5', ST_GeomFromText('POINT(37.7749 -100.4194)'), 'Private security', true, 2),
('+34444444444', 'rrrrrrrrr@gmail.com', 'Shishao 5', ST_GeomFromText('POINT(37.7749 -100.4194)'), 'Private security', true, 3),
UNLOCK TABLES;


CREATE TABLE IF EXISTS rooms (
id CHAR(3) NOT NULL,
num_personas INT NOT NULL,
internet_type ENUM('Fiber', 'Cable', 'Satellite') NOT NULL,
is_smoker BOOLEAN NOT NULL,
has_terrace BOOLEAN NOT NULL,
id_hotel INT,
PRIMARY KEY (id),
CONSTRAINT hotel_fk FOREIGN KEY (id_hotel) REFERENCES hotels (id)
);

LOCK TABLES rooms WRITE;
INSERT INTO rooms (id, num_personas, internet_type, is_smoker, has_terrace, id_hotel) VALUES
('103', 1, 'Fiber', false, true, 1),
('204', 1, 'Fiber', false, true, 1),
('302', 3, 'Fiber', false, true, 1),
UNLOCK TABLES;
