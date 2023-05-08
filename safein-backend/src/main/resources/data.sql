create database if not exists safein_test;
use safein_test;


/* Users Table */
CREATE TABLE IF NOT EXISTS susers(
id INT NOT NULL AUTO_INCREMENT,
username varchar(100) NOT NULL UNIQUE,
password varchar (255) NOT NULL,
nomapels varchar(255) NOT NULL,
email varchar(255) NOT NULL,
role NVARCHAR(255) NOT NULL,
PRIMARY KEY (id)
);

INSERT INTO susers (username,password,nomapels,email, role) value ("admin",'$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.',"admin","nomail@gmail.com", "admin");
INSERT INTO susers (username,password,nomapels,email, role) value ("marraya",'$2a$10$6pBWgEtPi/kMtZ7l4ik6SudQGHyf1.oi0q/5VvKzpgZ32yZ88Iw9q',"Maria Raices","mrraynet@gmail.com", "editor");
INSERT INTO susers (username,password,nomapels,email, role) value ("AntAn",'$2a$10$xwVYF5bGk7V2b.HSmy/haOdN9QGQvjLIWeYrJqDR5v8E9urCD4zUW',"Antonio Andres","antmannn@gmail.com", "editor");
INSERT INTO susers (username,password,nomapels,email, role) value ("NicoGico",'$2a$10$s.8JK58WTHv6tsHb6/FV/e5VZ1ZcAdmhxIvukAOdEYHMWHSKsFLJS',"Nicolas Gimenez","nicogi@gmail.com", "user");

/* Countries Table */
CREATE TABLE IF NOT EXISTS countries (
id INT NOT NULL AUTO_INCREMENT,
country_code varchar(2) NOT NULL UNIQUE,
country_name varchar(255) NOT NULL,
latitude DOUBLE NOT NULL,
longitude DOUBLE NOT NULL,
situation ENUM ("Tension Between Countries","Risk of war","War","High crime","Political instability","Natural Disaster") NOT NULL,
PRIMARY KEY (id)
);
INSERT INTO countries (country_code,country_name,latitude,longitude,situation) VALUE ('UA',"Ukraine", 49.0000000, 32.0000000,'War');
INSERT INTO countries (country_code,country_name,latitude,longitude,situation) VALUE ('SO',"Somalia", 10.0000000, 49.0000000,'War');
INSERT INTO countries (country_code,country_name,latitude,longitude,situation) VALUE ('ID',"Indonesia", -5.0000000, 120.0000000,'Natural Disaster');
/* Customers Table */
CREATE TABLE IF NOT EXISTS customers(
id int NOT NULL auto_increment,
name varchar(255) NOT NULL,
phonenumber varchar(20) NOT NULL,
email varchar(255) NOT NULL,
press_media varchar(255) NOT NULL,
doc_identificator varchar(50) NOT NULL,
num_identificator varchar(50) NOT NULL,
country_id int NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (country_id) REFERENCES countries(id)
);

INSERT INTO customers (name,phonenumber,email,press_media,doc_identificator,num_identificator,country_id) VALUES ("Maks Levin","+341725923","mklevis@gmail.com","LB.ua","DNI","5263383944",1);
INSERT INTO customers (name,phonenumber,email,press_media,doc_identificator,num_identificator,country_id) VALUES ("Robert Capa","+34183564784","rcopa@gmail.com","independiente","DNI","5263744744",2);
INSERT INTO customers (name,phonenumber,email,press_media,doc_identificator,num_identificator,country_id) VALUES ("Frédéric Leclerc-Imhoff","+341445623","freddy@gmail.com","BFMTV","DNI","5263374744",3);

 SELECT * FROM customers;

/* Bookings Table */
CREATE TABLE IF NOT EXISTS bookings (
  id int not null auto_increment,
  amount double default null,
  num_people int default null,
  is_payed boolean not null default 0,/* By default false*/
  is_pending_pay boolean not null default 0,/* By default false*/
  customer_id int,
  suser_id int,  
  primary key (id),
  constraint customer_ibfk_1 FOREIGN KEY (customer_id) REFERENCES customers(id),
  constraint suser_ibfk_1 FOREIGN KEY (suser_id) REFERENCES susers(id)
);

INSERT INTO bookings (amount, num_people, is_payed, is_pending_pay, customer_id, suser_id) VALUES (250.00, 1, true, false, 1, 1);
INSERT INTO bookings (amount, num_people, is_payed, is_pending_pay, customer_id, suser_id) VALUES (351.12, 1, false, true, 2, 2);
INSERT INTO bookings (amount, num_people, is_payed, is_pending_pay, customer_id, suser_id) VALUES (454.9, 2, true, false, 3, 3);
INSERT INTO bookings (amount, num_people, is_payed, is_pending_pay, customer_id, suser_id) VALUES (42.365, 1, false, true, 1, 2);

/* Cities Table */
CREATE TABLE IF NOT EXISTS cities (
id INT NOT NULL AUTO_INCREMENT,
latitude DOUBLE NOT NULL,
longitude DOUBLE NOT NULL,
name VARCHAR(255) NOT NULL,
id_country INT,
PRIMARY KEY (id),
CONSTRAINT country_fk FOREIGN KEY (id_country) REFERENCES countries (id)
);

-- POINT(latitude, longitude)
INSERT INTO cities (latitude, longitude, name, id_country) VALUES (37.7749, -122.4194, 'Kirtze', 1);
INSERT INTO cities (latitude, longitude, name, id_country) VALUES (37.7749, -12.4194, 'Uowe', 2);
INSERT INTO cities (latitude, longitude, name, id_country) VALUES (38.7749, -122.4194, 'Roj', 3);


/* Hotels Table */
CREATE TABLE IF NOT EXISTS  hotels (
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(255) NOT NULL,
phonenumber VARCHAR(20) NOT NULL,
email VARCHAR(255) NOT NULL,
address VARCHAR(255) NOT NULL,
latitude DOUBLE NOT NULL,
longitude DOUBLE NOT NULL,
security_level ENUM('Diplomatic coverage and private security', 'Private security', 'Diplomatic coverage'),
energy_suficient BOOLEAN,
id_city INT,
PRIMARY KEY (id),
CONSTRAINT city_fk FOREIGN KEY (id_city) REFERENCES cities (id)
);
INSERT INTO hotels (name, phonenumber, email, address, latitude, longitude, security_level, energy_suficient, id_city) VALUES
('Hotel Palace' ,'+34555555555', 'reboca@gmail.com', 'Arbeitzer street 5', 37.7749, -122.4194, 'Diplomatic coverage and private security', true, 1),
('Hotel Serpiente Feliz' ,'+34777777777', 'redestro@gmail.com', 'Uburubao street 5', 37.7749, -100.4194, 'Private security', true, 2),
('Hotel Me Da Lo Mismo', '+34444444444', 'rrrrrrrrr@gmail.com', 'Shishao 5', 37.7749, -100.4194, 'Private security', true, 3);

/* Rooms Table */
CREATE TABLE IF NOT EXISTS rooms (
id INT NOT NULL AUTO_INCREMENT,
room_code CHAR(3) NOT NULL UNIQUE,
price_per_night FLOAT NOT NULL,
num_people INT NOT NULL,
internet_type ENUM('Fiber', 'Cable', 'Satellite') NOT NULL,
is_smoker BOOLEAN NOT NULL,
has_terrace BOOLEAN NOT NULL,
hotel_id INT,
PRIMARY KEY (id),
CONSTRAINT hotel_fk FOREIGN KEY (hotel_id) REFERENCES hotels (id)
);

INSERT INTO rooms (room_code, price_per_night, num_people, internet_type, is_smoker, has_terrace, hotel_id) VALUES
('103', 59.99, 1, 'Fiber', false, true, 1),
('204', 59.99, 1, 'Fiber', false, true, 1),
('302', 59.99, 3, 'Fiber', false, true, 1);




/* Handles Table */
CREATE TABLE IF NOT EXISTS handles (
  id int not null auto_increment,
  arrival_date datetime default null,
  departure_date datetime default null,
  booking_id int,
  room_id int,
  primary key (id),
  constraint booking_ibfk_1 FOREIGN KEY (booking_id) REFERENCES bookings(id),
  constraint room_ibfk_1 FOREIGN KEY (room_id) REFERENCES rooms(id)
);

INSERT INTO handles (arrival_date, departure_date, booking_id, room_id) VALUES ('2023-09-14 12:00:00', '2023-09-16 12:00', 1, 1);
INSERT INTO handles (arrival_date, departure_date, booking_id, room_id) VALUES ('2023-06-1 12:00:00', '2023-06-1 12:00:00', 2, 1);
INSERT INTO handles (arrival_date, departure_date, booking_id, room_id) VALUES ('2023-07-18 12:00:00', '2023-07-15 12:00:00', 3, 2);
INSERT INTO handles (arrival_date, departure_date, booking_id, room_id) VALUES ('2023-06-17 12:00:00', '2023-08-14 12:00:00', 1, 3);
