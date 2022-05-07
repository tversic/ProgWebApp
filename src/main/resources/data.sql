insert into hardware(id, name, code, price, type, stock) values
    (1, 'LenovoHDD', '0000', 300.00, 'STORAGE', 10),
    (2, 'NvidaGtx', '0001', 400.00, 'GPU', 3);

insert into review( name, tekst, ocjena, id_hardware) values
                  ('review1', 'txt1', 'ONESTAR', 1),
                  ('review2', 'txt2', 'TWOSTAR', 2);
