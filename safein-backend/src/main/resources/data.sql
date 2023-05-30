create database if not exists safein_test;
use railway;


/* Users Table */
DROP TABLE IF EXISTS susers;
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

DROP TABLE IF EXISTS countries;
/* Countries Table */
CREATE TABLE IF NOT EXISTS countries (
id INT NOT NULL AUTO_INCREMENT,
country_code varchar(2) NOT NULL UNIQUE,
country_name varchar(255) NOT NULL,
latitude DOUBLE NOT NULL,
longitude DOUBLE NOT NULL,
situation ENUM ("Tension Between Countries","Risk of war","War","High crime","Political instability","Natural Disaster","Peace") NOT NULL,
PRIMARY KEY (id)
);

INSERT INTO countries (country_code,country_name,latitude,longitude,situation) VALUE ('UA',"Ukraine", 49.0000000, 32.0000000,'War');
INSERT INTO countries (country_code,country_name,latitude,longitude,situation) VALUE ('SO',"Somalia", 10.0000000, 49.0000000,'War');
INSERT INTO countries (country_code,country_name,latitude,longitude,situation) VALUE ('ID',"Indonesia", -5.0000000, 120.0000000,'Natural Disaster');

insert into countries(country_code,country_name,latitude,longitude,situation) value("VN","Vietnam",16.0000000,106.0000000,"War");
insert into countries(country_code,country_name,latitude,longitude,situation) value("CO","Corea",37.0000000,127.50000000,"High crime");
insert into countries(country_code,country_name,latitude,longitude,situation) value("BA","Bosnia and Herzegovina", 43.9159,17.6791,"Natural Disaster");
insert into countries(country_code,country_name,latitude,longitude,situation) value("DE","Germany",51.0504,13.7373,"Political instability");
insert into countries(country_code,country_name,latitude,longitude,situation) value("AF","Afghanistan",33.0000000,65.0000000,"Natural Disaster");
insert into countries(country_code,country_name,latitude,longitude,situation) value("GB","United Kingdom",54.0000000,-2.0000000,"Risk of war");
insert into countries(country_code,country_name,latitude,longitude,situation) value("LB","Lebanon",33.8938,35.5018,"Natural Disaster");


/* Customers Table */
DROP TABLE IF EXISTS customers;
CREATE TABLE IF NOT EXISTS customers(
id int NOT NULL auto_increment,
name varchar(255) NOT NULL,
phonenumber varchar(20) NOT NULL,
email varchar(255) NOT NULL,
press_media varchar(255) NOT NULL,
doc_identificator varchar(50) NOT NULL,
num_identificator varchar(50) NOT NULL,
country_id int NOT NULL,
CONSTRAINT unique_combination UNIQUE (doc_identificator, num_identificator),
PRIMARY KEY (id),
FOREIGN KEY (country_id) REFERENCES countries(id)
);

INSERT INTO customers (name,phonenumber,email,press_media,doc_identificator,num_identificator,country_id) VALUE ("Maks Levin","+341725923","mklevis@gmail.com","LB.ua","DNI","5263384",1);
INSERT INTO customers (name,phonenumber,email,press_media,doc_identificator,num_identificator,country_id) VALUE ("Robert Capa","+34183564","rcopa@gmail.com","independiente","DNI","5263745",2);
INSERT INTO customers (name,phonenumber,email,press_media,doc_identificator,num_identificator,country_id) VALUE ("Frédéric Leclerc-Imhoff","+341445623","freddy@gmail.com","BFMTV","DNI","5263344",3);

insert into customers (name,phonenumber,email,press_media,doc_identificator,num_identificator,country_id) value("Christiane Amanpour","+3473181","chrisampour@gmail.com","CNN","DNI","172854544",3);
insert into customers (name,phonenumber,email,press_media,doc_identificator,num_identificator,country_id) value("Sebastian Junger","+3146173","sebastian@gmail.com","Vanity Fair","DNI","1723944",5);
insert into customers (name,phonenumber,email,press_media,doc_identificator,num_identificator,country_id) value("Ana Alba","+39273834","analba@efeagency.com","Agencia EFE","DNI","17494944",3);
insert into customers (name,phonenumber,email,press_media,doc_identificator,num_identificator,country_id) value("Gervasio Sánchez","+34193394","gerbasan@gmail.com","Freelance","DNI","173944",9);
insert into customers (name,phonenumber,email,press_media,doc_identificator,num_identificator,country_id) value("Alex Crawford","+4017234","alexcrow@gmail.com","Sky News","DNI","17303944",4);
insert into customers (name,phonenumber,email,press_media,doc_identificator,num_identificator,country_id) value("Sebastian Junger","+3579304","sebastianjuger@gmail.com","ABC News","DNI","13383944",8);
insert into customers (name,phonenumber,email,press_media,doc_identificator,num_identificator,country_id) value("Ghaith Abdul-Ahad","+32278494","ghabdul@gmail.com","The Guardian","DNI","1738383944",5);
insert into customers (name,phonenumber,email,press_media,doc_identificator,num_identificator,country_id) value("Kate Adie","+42199339","kateadd@gmail.com","BBC News","DNI","139937944",5);
insert into customers (name,phonenumber,email,press_media,doc_identificator,num_identificator,country_id) values("Martha Gellhorn","+201405","mathagell@gmail.com","Collier's Weekly","DNI","1283944",7);
insert into customers (name,phonenumber,email,press_media,doc_identificator,num_identificator,country_id) values("James Nachtwey","+4789422","jamesnac@gmail.com","Time magazine","DNI","1738344",8);


/* Bookings Table */
DROP TABLE IF EXISTS bookings;

CREATE TABLE IF NOT EXISTS bookings (
  id int not null auto_increment,
  amount double default null ,
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

INSERT INTO bookings (amount, num_people, is_payed, is_pending_pay, customer_id, suser_id) VALUES (300, 3, false, true, 5, 4);
INSERT INTO bookings (amount, num_people, is_payed, is_pending_pay, customer_id, suser_id) VALUES (255, 1, true, false, 4, 3);
INSERT INTO bookings (amount, num_people, is_payed, is_pending_pay, customer_id, suser_id) VALUES (251, 2, false, true, 6, 4);
INSERT INTO bookings (amount, num_people, is_payed, is_pending_pay, customer_id, suser_id) VALUES (152, 3, true, false, 7, 2);
INSERT INTO bookings (amount, num_people, is_payed, is_pending_pay, customer_id, suser_id) VALUES (50, 5, false, true, 8, 1);
INSERT INTO bookings (amount, num_people, is_payed, is_pending_pay, customer_id, suser_id) VALUES (200, 2, true, false, 8, 2);
INSERT INTO bookings (amount, num_people, is_payed, is_pending_pay, customer_id, suser_id) VALUES (230, 3, false, true, 6, 3);
INSERT INTO bookings (amount, num_people, is_payed, is_pending_pay, customer_id, suser_id) VALUES (120, 2, true, false, 4, 4);
INSERT INTO bookings (amount, num_people, is_payed, is_pending_pay, customer_id, suser_id) VALUES (172, 5, true, false, 7, 2);
INSERT INTO bookings (amount, num_people, is_payed, is_pending_pay, customer_id, suser_id) VALUES (70, 3, true, false, 4, 1);


/* Cities Table */
DROP TABLE IF EXISTS cities;

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
INSERT INTO cities (latitude, longitude, name, id_country) VALUE (37.7749, -122.4194, 'Kirtze', 1);
INSERT INTO cities (latitude, longitude, name, id_country) VALUE (37.7749, -12.4194, 'Uowe', 2);
INSERT INTO cities (latitude, longitude, name, id_country) VALUE (38.7749, -122.4194, 'Roj', 3);


insert into cities(latitude,longitude,name,id_country) value (34.5281300,69.1723300,"Kabul",4);
insert into cities (latitude,longitude,name,id_country) value(10.6876,16.666,"Saigon",5);
insert into cities (latitude,longitude,name,id_country) value(35.166668,129.066666,"Busan",6);
insert into cities (latitude,longitude,name,id_country) value( 43.8563,18.4131,'Sarajevo',7);
insert into cities (latitude,longitude,name,id_country) value(33.3152,13.7373,'Dresde',8);
insert into cities (latitude,longitude,name,id_country) value(54.5973,5.9301,'Belfast',9);
insert into cities(latitude,longitude,name,id_country) value (52.5243700,13.4105300,"Berlina",8);


/* Hotels Table */
DROP TABLE IF EXISTS hotels;

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

insert into hotels (name,phonenumber,email,address,latitude,longitude,security_level,energy_suficient,id_city) value ("Hotel Chill",+40687532,"chillhotel@gmail.com","Av chill",42.8467,-53.0000000,"Diplomatic Coverage",true,3);
insert into hotels (name,phonenumber,email,address,latitude,longitude,security_level,energy_suficient,id_city) value ("Hotel Fast",+5281929303,"fasthotel@hotelfast.com","fstestroad 15",32.7495,-7.8500,"Private Security",false,7);
insert into hotels (name,phonenumber,email,address,latitude,longitude,security_level,energy_suficient,id_city) value ("Hotel Tell",+4381920304,"tellotel@tell.com","tellv street",27.81992,-1.00003,"Diplomatic Coverage",true,5);
insert into hotels (name,phonenumber,email,address,latitude,longitude,security_level,energy_suficient,id_city) value ("Hotel Fall",+565950045,"hofall@fall.com","hotfall 55",45.8909,-20.10102,"Private Security",false,2);
insert into hotels (name,phonenumber,email,address,latitude,longitude,security_level,energy_suficient,id_city) value ("Hotel Save",+6727239404,"hosave@gmail.com","Calle Meloso",89.713,-6.8192933,"Diplomatic coverage and private security",false,4);
insert into hotels (name,phonenumber,email,address,latitude,longitude,security_level,energy_suficient,id_city) value ("Hotel Base",+7291023893,"baseho@gmail.com","Basses Str",21.293,-8.028384,"Private Security",true,7);
insert into hotels (name,phonenumber,email,address,latitude,longitude,security_level,energy_suficient,id_city) value ("Hotel Mel",+8128729393,"honeyhotl@gmail.com","Stret teet",32.8181,-5.9922,"Diplomatic coverage and private security",true,6 );
insert into hotels (name,phonenumber,email,address,latitude,longitude,security_level,energy_suficient,id_city) value ("Alive Resort",+92829304,"keepalive@gmail.com","Avery rue",7.9123,6.1733,"Private Security",false,8);
insert into hotels (name,phonenumber,email,address,latitude,longitude,security_level,energy_suficient,id_city) value ("Rest Resort",+607283934,"restort@gmail.com","Street Hey",8.5628,-28.91028,"Diplomatic Coverage",false,8);
insert into hotels (name,phonenumber,email,address,latitude,longitude,security_level,energy_suficient,id_city) value ("Hold Hotel", +78912345,"holtel@gmail.com","Unem street 5",6.91823,-9.00234,"Diplomatic coverage and private security",true,1);
INSERT INTO hotels (name, phonenumber, email, address, latitude, longitude, security_level, energy_suficient, id_city) VALUE
('Hotel Palace' ,'+34555555555', 'reboca@gmail.com', 'Arbeitzer street 5', 37.7749, -122.4194, 'Diplomatic coverage and private security', true, 1),
('Hotel Serpiente Feliz' ,'+34777777777', 'redestro@gmail.com', 'Uburubao street 5', 37.7749, -100.4194, 'Private security', true, 2),
('Hotel Me Da Lo Mismo', '+34444444444', 'rrrrrrrrr@gmail.com', 'Shishao 5', 37.7749, -100.4194, 'Private security', true, 3);

/* Rooms Table */
DROP TABLE IF EXISTS rooms;

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

insert into rooms (room_code,price_per_night,num_people,internet_type,is_smoker,has_terrace,hotel_id) values(809,10,3,"Cable",0,0,5);
insert into rooms (room_code,price_per_night,num_people,internet_type,is_smoker,has_terrace,hotel_id) values(077,29,3,"Satellite",0,0,4);
insert into rooms (room_code,price_per_night,num_people,internet_type,is_smoker,has_terrace,hotel_id) values(053,21,4,"Fiber",1,0,7);
insert into rooms (room_code,price_per_night,num_people,internet_type,is_smoker,has_terrace,hotel_id) values(020,20,1,"Cable",1,0,5);
insert into rooms (room_code,price_per_night,num_people,internet_type,is_smoker,has_terrace,hotel_id) values(120,42.2,2,"Fiber",1,1,2);
insert into rooms (room_code,price_per_night,num_people,internet_type,is_smoker,has_terrace,hotel_id) values(050,50.09,5,"Satellite",1,0,3);
insert into rooms (room_code,price_per_night,num_people,internet_type,is_smoker,has_terrace,hotel_id) values(001,53.50,3,"Cable",1,1,4);
insert into rooms (room_code,price_per_night,num_people,internet_type,is_smoker,has_terrace,hotel_id) values(203,50,4,"Fiber",0,1,6);
insert into rooms (room_code,price_per_night,num_people,internet_type,is_smoker,has_terrace,hotel_id) values(800,29,3,"Satellite",1,1,5);
insert into rooms (room_code,price_per_night,num_people,internet_type,is_smoker,has_terrace,hotel_id) values(080,10,2,"Cable",0,1,6);
INSERT INTO rooms (room_code, price_per_night, num_people, internet_type, is_smoker, has_terrace, hotel_id) VALUES('204', 59.99, 1, 'Fiber', false, true, 1), ('302', 59.99, 3, 'Fiber', false, true, 1);





DROP TABLE IF EXISTS handles;

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


INSERT INTO handles (arrival_date, departure_date, booking_id, room_id) VALUES ('2023-09-13 14:10:05', '2023-09-16 12:00', 4, 7);
INSERT INTO handles (arrival_date, departure_date, booking_id, room_id) VALUES ('2023-09-16 20:03:07', '2023-09-16 12:00', 6, 8);
INSERT INTO handles (arrival_date, departure_date, booking_id, room_id) VALUES ('2023-09-19 22:50:20', '2023-09-16 12:00', 5, 9);
INSERT INTO handles (arrival_date, departure_date, booking_id, room_id) VALUES ('2023-09-25 18:50:50', '2023-09-16 12:00', 5, 7);
INSERT INTO handles (arrival_date, departure_date, booking_id, room_id) VALUES ('2023-09-29 12:00:00', '2023-09-16 12:00', 7, 6);
INSERT INTO handles (arrival_date, departure_date, booking_id, room_id) VALUES ('2023-09-30 12:00:00', '2023-09-16 12:00', 1, 2);



