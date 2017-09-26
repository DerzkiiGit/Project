DROP TABLE IF EXISTS user;
CREATE TABLE user(ID BIGINT(20) NOT NULL AUTO_INCREMENT UNIQUE, name VARCHAR (25) NOT NULL, age INT(11) NOT NULL, isAdmin BIT(1) NOT NULL, createDate TIMESTAMP, PRIMARY KEY(ID));
COMMIT;
INSERT INTO user(name, age, isAdmin) VALUES ('Blazcowic', 11, 1);
INSERT INTO user(name, age, isAdmin) VALUES ('Ivan',20, 0);
INSERT INTO user(name, age, isAdmin) VALUES ('Ilya', 33, 1);
INSERT INTO user(name, age, isAdmin) VALUES ('Ivan', 15, 0);
INSERT INTO user(name, age, isAdmin) VALUES ('Vasya', 9, 0);
INSERT INTO user(name, age, isAdmin) VALUES ('Oleg', 30, 1);
INSERT INTO user(name, age, isAdmin) VALUES ('Olga', 25, 0);
INSERT INTO user(name, age, isAdmin) VALUES ('Zog', 200, 1);
COMMIT;
