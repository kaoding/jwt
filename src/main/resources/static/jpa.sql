INSERT INTO USER (id, username, PASSWORD) VALUES (1, 'bruce', '$2a$10$kM64A2eLh.L6cyS2mbnl2Oc7sP.yBJlt0gMrYK.QdPVXmvuMKNUse');
INSERT INTO USER (id, username, PASSWORD) VALUES (2, 'wintry', '$2a$10$kM64A2eLh.L6cyS2mbnl2Oc7sP.yBJlt0gMrYK.QdPVXmvuMKNUse');
INSERT INTO USER (id, username, PASSWORD) VALUES (3, 'mike', '$2a$10$kM64A2eLh.L6cyS2mbnl2Oc7sP.yBJlt0gMrYK.QdPVXmvuMKNUse');

INSERT INTO role (id, NAME) VALUES (1, 'ROLE_USER');
INSERT INTO role (id, NAME) VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO user_role (user_id, role_id) VALUES (3, 1);

INSERT INTO product (id, NAME) VALUES ('1', 'sts');
INSERT INTO product (id, NAME) VALUES ('2', 'agv');
INSERT INTO product (id, NAME) VALUES ('3', 'asc');

INSERT INTO device (id, NAME, product_id) VALUES ('1', 'device-1',1);
INSERT INTO device (id, NAME, product_id) VALUES ('2', 'device-2',1);
INSERT INTO device (id, NAME, product_id) VALUES ('3', 'device-3',2);