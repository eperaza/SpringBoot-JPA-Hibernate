DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS role;

CREATE TABLE role (
  id INT AUTO_INCREMENT PRIMARY KEY,
  role_name VARCHAR(250) DEFAULT NULL
  
);

CREATE TABLE user (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  id_role INT NULL 
);

INSERT INTO role (id, role_name) VALUES (4, 'admin');

INSERT INTO user (name, email, id_role) VALUES ('rupe', 'rupe@gmail.com', 4);
INSERT INTO user (name, email, id_role) VALUES ('edu', 'rupe@gmail.com', 4);
INSERT INTO user (name, email, id_role) VALUES ('jumil', 'rupe@gmail.com', 4);

