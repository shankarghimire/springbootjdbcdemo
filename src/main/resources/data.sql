create table person
(
   id integer not null,
   name varchar(255) not null,
   location varchar(255),
   birth_date timestamp,
   primary key(id)
);

INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(101,  'Shankar', 'Brampton',sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(102,  'Sam', 'Toronto',sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(103,  'Rama', 'London',sysdate());