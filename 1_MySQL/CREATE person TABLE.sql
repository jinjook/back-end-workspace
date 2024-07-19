CREATE TABLE person(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20),
    age INT,
    addr VARCHAR(50)
);

SELECT * FROM person;

SELECT * FROM person WHERE id = 2;


DROP TABLE member;

-- id가 primary key가 아닐 때는 UNIQUE 걸어주기
CREATE TABLE member	(
	id VARCHAR(20) PRIMARY KEY,
	password VARCHAR(50),
    name VARCHAR(20)
);

SELECT * FROM member;


CREATE TABLE bank (
	name VARCHAR(20),
    balance INT
    );

SELECT * FROM bank;

INSERT INTO bank VALUES('동엽', 100000);
INSERT INTO bank VALUES('동호', 0);

UPDATE bank SET balance = 100000 WHERE name ='동엽';
