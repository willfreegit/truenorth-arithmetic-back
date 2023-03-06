INSERT INTO users (username, password)
VALUES ('will@hotmail.com', '$2a$10$.VMlWhp5pEoAiIlX9Y5m1unZ01dUePG7yqAE.Vyp6QRi/xxRs7BcO');

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO user_roles(user_id, role_id) VALUES(1, 1);