
create database safein_test;
use safein_test;

/* Users Table */
CREATE TABLE IF NOT EXISTS users(
username varchar(100) NOT NULL,
password varchar (255) NOT NULL,
nomApels varchar(255) NOT NULL,
email varchar(255) NOT NULL,
PRIMARY KEY (username)
);

LOCK TABLES users WRITE;
INSERT INTO users (username,password,nomApels,email) value ("marraya","Ma@ara","Maria Raices","mrraynet@gmail.com");
INSERT INTO users (username,password,nomApels,email) value ("AntAn","AnA#$","Antonio Andres","antmannn@gmail.com");
INSERT INTO users (username,password,nomApels,email) values ("NicoGico","Ni#$Gii","Nicolas Gimenez","nicogi@gmail.com");
UNLOCK TABLES;


/* Countries Table */
CREATE TABLE IF NOT EXISTS countries (
country_code varchar(2) NOT NULL,
country_name varchar(255) NOT NULL,
location POINT NOT NULL,
situation ENUM ("Tension Between Countries","Risk of war","War","high crime","political instability","Natural Disaster") NOT NULL,
PRIMARY KEY (country_code)
);

LOCK TABLES countries WRITE;
INSERT INTO countries (country_code,country_name,location,situation) VALUE ("UA","Ukraine",ST_GeomFromText('POINT(49.0000000 32.0000000)'),"War");
INSERT INTO countries (country_code,country_name,location,situation) VALUE ("SO","Somalia",ST_GeomFromText('POINT(10.0000000 49.0000000)'),"War");
INSERT INTO countries (country_code,country_name,location,situation) VALUE ("ID","Indonesia",ST_GeomFromText('POINT(-5.0000000 120.0000000)'),"Natural Disaster");
UNLOCK TABLES;

/* Clients Table */
CREATE TABLE IF NOT EXISTS clients(
id int(20) NOT NULL auto_increment,
name varchar(255) NOT NULL,
Phonenumber varchar(20) NOT NULL,
email varchar(255) NOT NULL,
press_media varchar(255) NOT NULL,
doc_identificator varchar(50) NOT NULL,
num_identificator varchar(50) NOT NULL,
country_id varchar(2) NOT NULL, ####Notacion ISO 3166-1 alpha-2
PRIMARY KEY (id),
FOREIGN KEY (country_id) REFERENCES countries(country_code)
);

LOCK TABLES clients WRITE;
INSERT INTO clients (name,Phonenumber,email,press_media,doc_identificator,num_identificator,country_id) VALUES ("Maks Levin","+341725923","mklevis@gmail.com","LB.ua","DNI","5263383944","UA");
INSERT INTO clients (name,Phonenumber,email,press_media,doc_identificator,num_identificator,country_id) VALUES ("Robert Capa","+34183564784","rcopa@gmail.com","independiente","DNI","5263744744","SO");
INSERT INTO clients (name,Phonenumber,email,press_media,doc_identificator,num_identificator,country_id) VALUES ("Frédéric Leclerc-Imhoff","+341445623","freddy@gmail.com","BFMTV","DNI","5263374744","ID");
UNLOCK TABLES;

/* Bookings Table */
CREATE TABLE IF NOT EXISTS bookings (
  id int not null auto_increment,
  import double default null,
  num_persons int default null,
  is_payed boolean not null default 0,/* By default false*/
  is_pending_pay boolean not null default 0,/* By default false*/
  client_id int,
  user_id varchar(100),  
  primary key (id),
  constraint client_ibfk_1 FOREIGN KEY (client_id) REFERENCES clients(id),
  constraint user_ibfk_1 FOREIGN KEY (user_id) REFERENCES users(username)
);

lock tables bookings write;
INSERT INTO bookings (import, num_persons, is_payed, is_pending_pay, client_id, user_id) VALUES (250.00, 1, true, false, 1, 'marraya');
INSERT INTO bookings (import, num_persons, is_payed, is_pending_pay, client_id, user_id) VALUES (351.12, 1, false, true, 2, 'AntAn');
INSERT INTO bookings (import, num_persons, is_payed, is_pending_pay, client_id, user_id) VALUES (454.9, 2, true, false, 3, 'marraya');
INSERT INTO bookings (import, num_persons, is_payed, is_pending_pay, client_id, user_id) VALUES (42.365, 1, false, true, 1, 'AntAn');
UNLOCK TABLES;

/* Cities Table */
CREATE TABLE IF NOT EXISTS cities (
id INT NOT NULL AUTO_INCREMENT,
location POINT NOT NULL,
name VARCHAR(255) NOT NULL,
id_country VARCHAR(2),
PRIMARY KEY (id),
CONSTRAINT country_fk FOREIGN KEY (id_country) REFERENCES countries (country_code)
);

LOCK TABLES cities WRITE;
-- POINT(latitude, longitude)
INSERT INTO cities (location, name, id_country) VALUES (ST_GeomFromText('POINT(37.7749 -122.4194)'), 'Kirtze', 'UA');
INSERT INTO cities (location, name, id_country) VALUES (ST_GeomFromText('POINT(37.7749 -12.4194)'), 'Uowe', 'SO');
INSERT INTO cities (location, name, id_country) VALUES (ST_GeomFromText('POINT(38.7749 -122.4194)'), 'Roj', 'ID');
UNLOCK TABLES;


/* Hotels Table */
CREATE TABLE IF NOT EXISTS  hotels (
id INT NOT NULL AUTO_INCREMENT,
phonenumber VARCHAR(20) NOT NULL,
email VARCHAR(255) NOT NULL,
address VARCHAR(255) NOT NULL,
location POINT NOT NULL,
security_level ENUM('Diplomatic coverage and private security', 'Private security', 'Diplomatic coverage'),
enery_suficient BOOLEAN,
id_city INT,
PRIMARY KEY (id),
CONSTRAINT city_fk FOREIGN KEY (id_city) REFERENCES cities (id)
);

LOCK TABLES hotels WRITE;
INSERT INTO hotels (phonenumber, email, address, location, security_level, enery_suficient, id_city) VALUES
('+34555555555', 'reboca@gmail.com', 'Arbeitzer street 5', ST_GeomFromText('POINT(37.7749 -122.4194)'), 'Diplomatic coverage and private security', true, 1),
('+34777777777', 'redestro@gmail.com', 'Uburubao street 5', ST_GeomFromText('POINT(37.7749 -100.4194)'), 'Private security', true, 2),
('+34444444444', 'rrrrrrrrr@gmail.com', 'Shishao 5', ST_GeomFromText('POINT(37.7749 -100.4194)'), 'Private security', true, 3);
UNLOCK TABLES;


/* Rooms Table */
CREATE TABLE IF NOT EXISTS rooms (
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
('302', 3, 'Fiber', false, true, 1);
UNLOCK TABLES;


/* Handles Table */
CREATE TABLE IF NOT EXISTS handles (
  id int not null auto_increment,
  arrival_date datetime default null,
  departure_date datetime default null,
  booking_id int,bookingsbookings
  room_id varchar(3),  
  primary key (id),
  constraint booking_ibfk_1 FOREIGN KEY (booking_id) REFERENCES bookings(id),
  constraint room_ibfk_1 FOREIGN KEY (room_id) REFERENCES rooms(id)
);

lock tables handles write;
INSERT INTO handles (arrival_date, departure_date, booking_id, room_id) VALUES ('2023-09-14 12:00:00', '2023-09-16 12:00', 1, '103');
INSERT INTO handles (arrival_date, departure_date, booking_id, room_id) VALUES ('2023-06-1 12:00:00', '2023-06-1 12:00:00', 2, '204');
INSERT INTO handles (arrival_date, departure_date, booking_id, room_id) VALUES ('2023-07-18 12:00:00', '2023-07-15 12:00:00', 3, '103');
INSERT INTO handles (arrival_date, departure_date, booking_id, room_id) VALUES ('2023-06-17 12:00:00', '2023-08-14 12:00:00', 1, '204');
UNLOCK TABLES;