DROP TABLE IF EXISTS clients;
CREATE TABLE clients(
id int(20) NOT NULL auto_increment,
name varchar(255) NOT NULL,
Phonenumber varchar(20) NOT NULL,
email varchar(255) NOT NULL,
press_media varchar(255) NOT NULL,
doc_identificator varchar(50) NOT NULL,
num_identificator int(50) NOT NULL,
country_id varchar(2) NOT NULL, ####Notacion ISO 3166-1 alpha-2
PRIMARY KEY (id)
);

LOCK TABLES clients WRITE;
INSERT INTO clients (name,Phonenumber,email,press_media,doc_identificator,num_identificator,coutry_id) VALUES ("Maks Levin","+341725923","mklevis@gmail.com","LB.ua","DNI",5263383944,"UA");
INSERT INTO clients (name,Phonenumber,email,press_media,doc_identificator,num_identificator,coutry_id) VALUES ("Robert Capa","+34183564784","rcopa@gmail.com","independiente","DNI",5263744744,"HU");
INSERT INTO clients (name,Phonenumber,email,press_media,doc_identificator,num_identificator,coutry_id) VALUES ("Frédéric Leclerc-Imhoff","+341445623","freddy@gmail.com","BFMTV","DNI",5263374744,"FR");
UNLOCK TABLES;

CREATE TABLE users(
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

CREATE TABLE countries (
country_code varchar(2) NOT NULL,
country_name varchar(255) NOT NULL,
location POINT NOT NULL,
situation ENUM ("Tension Between Countries","Risk of war","War","high crime","political instability","Natural Disaster") NOT NULL,
PRIMARY KEY (country_code)
);

LOCK TABLES countries WRITE;
INSERT INTO countries (country_code,country_name,location,situation) VALUE ("UA","Ukraine",Point(49.0000000,32.0000000),"War");
INSERT INTO countries (country_code,country_name,location,situation) VALUE ("SOM","Somalia",Point(10.0000000,49.0000000),"War");
INSERT INTO countries (country_code,country_name,location,situation) VALUE ("IND","Indonesia",Point(-5.0000000,120.0000000),"Natural Disaster");
UNLOCK TABLES;


