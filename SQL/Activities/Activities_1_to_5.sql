--Activity 1------

CREATE TABLE salesman (salesman_id int, salesman_name varchar2(32), salesman_city varchar2(32), commission int);
DESCRIBE salesman;

--Activity 2-----
INSERT INTO salesman VALUES(5001, 'James Hoog', 'New York', 15);
INSERT INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13);
INSERT INTO salesman VALUES(5005, 'Pitt Alex', 'London', 11);
INSERT INTO salesman VALUES(5006, 'McLyon', 'Paris', 14);
INSERT INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13);
INSERT INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12);

SELECT * FROM salesman;

--ACTIVITY 3------

SELECT salesman_id, salesman_city FROM salesman;

SELECT * FROM salesman WHERE salesman_city='Paris';

SELECT salesman_id, commission FROM salesman WHERE salesman_name='Paul Adam';

SELECT salesman_id, salesman_city FROM salesman where salesman_city = 'Paris';

--ACTIVITY 4-------

ALTER TABLE salesman ADD grade int;

UPDATE salesman SET grade=100;

SELECT * FROM salesman;

--ACTIVITY 5-------

UPDATE salesman SET grade=200 WHERE salesman_city='Rome';

UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

SELECT * FROM salesman;
