CREATE DATABASE IF NOT EXISTS mydb;
USE mydb;
DROP TABLE IF EXISTS  people;
DROP TABLE IF EXISTS  department;
CREATE TABLE people
(
    id INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(255),
    surname VARCHAR(255),
    address VARCHAR(255),
    birthday DATETIME,
    place_of_birth VARCHAR(255),
    salary INT(255),
    family BOOLEAN,
    permission_level INT(255),
    pass VARCHAR(255),
    department_id INT(255) REFERENCES department(id)
);

CREATE TABLE department
(
    id INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(255),
    description VARCHAR(255),
    director INT(255) REFERENCES people(id)
);

INSERT INTO department(department_name,description,director) 
VALUES 
('IT','IT department',3),
('Sales','Sales department',2),
('HR','HR department',4);
INSERT INTO People(firstname,surname,address,birthday,place_of_birth,salary,family,permission_level,pass,department_id)
VALUES 
   ('John','Do','Canada','2000-12-05','Canada',5000,True,1,'qwerty1',1),
   ('Salim','Salem','Morocco','1990-10-10','Romania',1000,False,2,'qwerty2',2),
   ('Yuri','Puturin','Russia','1997-01-02','Russia',2100,True,3,'qwerty3',1),
   ('Juan','De La Cruiz','Mexico','1987-09-02','USA',3100,True,3,'qwerty3',3);
INSERT INTO People(firstname,surname,address,birthday,place_of_birth,salary,family,department_id)
VALUES 
   ('Mike','Halls','France','1997-10-11','Germany',2400,True,1);