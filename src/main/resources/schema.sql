DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(120) NOT NULL,
  status BOOLEAN DEFAULT TRUE
);

DROP TABLE IF EXISTS roles;

CREATE TABLE roles (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(20) NOT NULL
);

DROP TABLE IF EXISTS user_roles;

CREATE TABLE user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL
);