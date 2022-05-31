insert into hardware(id, name, code, price, type, stock) values
    (1, 'LenovoHDD', '0000', 300.00, 'STORAGE', 10),
    (2, 'NvidaGtx', '0001', 400.00, 'GPU', 3);

insert into review( name, tekst, ocjena, id_hardware) values
                  ('DOBAR HARDWARE', 'Jako zadovoljan sa hardwareom preporučio bi svakome', 4, 1),
                  ('ZADOVOLJAN', 'Najbolji omjer cijene i kvalitete', 3, 2),
                  ('SUPER', 'jako dobar izbor', 5, 2),
                  ('VRLO DOBAR', 'Dobar ali cijena malo visoka', 2, 1);

insert into user(id, username, password)
values
    (1, 'user', '$2a$10$eALlaWi8QbGTU3oEbwKD1Op/EerkoScSU4q04.aT6y6ZHU70xBxda'), -- password = user
    (2, 'admin', '$2a$10$w8a/1w/UWiNk56Wd8g1UReyD0PgwRmoaaRTIJZwyEMBHnQXI8lbIe'),
    (3, 'deleter', '$2a$10$w8a/1w/UWiNk56Wd8g1UReyD0PgwRmoaaRTIJZwyEMBHnQXI8lbIe'); -- password = admin
insert into authority (id, authority_name)
values
    (1, 'ROLE_ADMIN'),
    (2, 'ROLE_USER'),
    (3, 'ROLE_DELETER');
insert into user_authority (user_id, authority_id)
values
    (1, 2),
    (2, 1),
    (3, 3);
