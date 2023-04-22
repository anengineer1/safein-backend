CREATE TABLE client(
id int NOT NULL auto_increment,
name varchar(255) NOT NULL,
Phonenumber int (20) NOT NULL,
email varchar(255) NOT NULL,
press_media varchar(255) NOT NULL,
doc_identificador varchar(50) NOT NULL,
country_id varchar(2) NOT NULL, ####Notacion ISO 3166-1 alpha-2
PRIMARY KEY (id)
);

CREATE TABLE user(
username varchar(100) NOT NULL,
password varchar (255) NOT NULL,
nomApels varchar(255) NOT NULL,
email varchar(255) NOT NULL,
PRIMARY KEY (username)
);

CREATE TABLE country (
country_code varchar(2) NOT NULL,
country_name varchar(255) NOT NULL,
location POINT NOT NULL,
situation ENUM ("Tension Between Countries","Risk of war","high crime","political instability","Natural Disaster") NOT NULL,
PRIMARY KEY (country_code)
);
