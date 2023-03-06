--INSERT DATA USER LOGIN SECURITY
INSERT INTO users (username, password)
VALUES ('will@hotmail.com', '$2a$10$.VMlWhp5pEoAiIlX9Y5m1unZ01dUePG7yqAE.Vyp6QRi/xxRs7BcO');
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
INSERT INTO user_roles(user_id, role_id) VALUES(1, 1);

--INSERT DATA MATH OPERATIONS
INSERT INTO operations(type, cost) VALUES('ADDITION', 0.1);
INSERT INTO operations(type, cost) VALUES('SUBTRACTION', 0.2);
INSERT INTO operations(type, cost) VALUES('MULTIPLICATION', 0.3);
INSERT INTO operations(type, cost) VALUES('DIVISION', 0.4);
INSERT INTO operations(type, cost) VALUES('SQUARE_ROOT', 0.5);
INSERT INTO operations(type, cost) VALUES('RANDOM_STRING', 1);

--INSERT USER INIT BALANCE
INSERT INTO user_balance(user_id, balance) VALUES(1, 10);