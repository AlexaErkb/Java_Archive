CREATE DATABASE IF NOT EXISTS mydb;
USE mydb;
DROP TABLE IF EXISTS  people;
CREATE TABLE people
(
    id INT  UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(255),
    surname VARCHAR(255),
    address VARCHAR(255),
    birthday DATETIME,
    place_of_birth VARCHAR(255),
    salary INT(255),
    family BOOLEAN
);
INSERT INTO People(firstname,surname,address)
VALUES 
   ('John','Do','Canada','2000-12-05','Canada',5000,True),
   ('Salim','Salem','Morocco','1990-10-10','Romania',1000,False),
   ('Yuri','Puturin','Russia','1997-01-02','Russia',2100,True),
   ('Juan','De La Cruiz','Mexico','1987-09-02','USA',3100,True);