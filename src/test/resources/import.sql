INSERT INTO users (username, password, enabled, first_name, last_name, email, created_at, updated_at) VALUES ('andres', '$2a$10$C3Uln5uqnzx/GswADURJGOIdBqYrly9731fnwKDaUdBkt/M3qvtLq', true, 'Andres', 'Guzman','profesor@bolsadeideas.com', now(), now());
INSERT INTO users (username, password, enabled, first_name, last_name, email, created_at, updated_at) VALUES ('admin', '$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK', true, 'John', 'Doe','jhon.doe@bolsadeideas.com', now(), now());

INSERT INTO roles (name, created_at, updated_at) VALUES ('ROLE_USER', now(), now());
INSERT INTO roles (name, created_at, updated_at) VALUES ('ROLE_ADMIN', now(), now());


INSERT INTO category (id, name, created_at, updated_at) VALUES (1, 'Category Example', NOW(), now());



INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);

/* Populate tabla productos */
INSERT INTO item (category_id, name, price, created_at, updated_at)
VALUES (1, 'Panasonic Pantalla LCD', 259990, NOW(), now());
INSERT INTO item (category_id, name, price, created_at, updated_at)
VALUES (1, 'Sony Camara digital DSC-W320B', 123490, NOW(), now());
INSERT INTO item (category_id, name, price, created_at, updated_at)
VALUES (1, 'Apple iPod shuffle', 1499990, NOW(), now());
INSERT INTO item (category_id, name, price, created_at, updated_at)
VALUES (1, 'Sony Notebook Z110', 37990, NOW(), now());
INSERT INTO item (category_id, name, price, created_at, updated_at)
VALUES (1, 'Hewlett Packard Multifuncional F2280', 69990, NOW(), now());
INSERT INTO item (category_id, name, price, created_at, updated_at)
VALUES (1, 'Bianchi Bicicleta Aro 26', 69990, NOW(), now());