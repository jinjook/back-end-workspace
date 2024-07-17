CREATE TABLE person(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20),
    age INT,
    addr VARCHAR(50)
);

SELECT * FROM person;

SELECT * FROM person WHERE id = 2;


DROP TABLE member;

CREATE TABLE member	(
	id VARCHAR(20) PRIMARY KEY,
	password VARCHAR(50),
    name VARCHAR(20)
);

SELECT * FROM member;