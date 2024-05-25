INSERT INTO especie (nmid, nombre_especie)
VALUES (1 , 'Perros'),
       (2 , 'Gatos'),
       (3 , 'Conejos'),
       (4 , 'Cobayas'),
       (5 , 'Hamsters'),
       (6 , 'Canarios'),
       (7 , 'Loros'),
       (8 , 'Peces ornamentales'),
       (9 , 'Tortugas'),
       (10 , 'Serpientes');

INSERT INTO ciudad (nmid, nombre_ciudad, codigo)
VALUES (1, 'Bogotá D.C.', 11001),
       (2, 'Medellín', 05001),
       (3, 'Barranquilla', 08001),
       (4, 'Montería', 23001),
       (5, 'Cereté', 23162),
       (6, 'Sahagún', 23672),
       (7, 'Planeta Rica', 23675),
       (8, 'Tierralta', 23807),
       (9, 'Lorica', 23417),
       (10, 'Montelíbano', 23555);

INSERT INTO propietario (tipo_doc, documento, nombre_propietario, direccion, telefono, nmid_ciudad)
VALUES ('1','1003045448','CARLOS DEL CASTILLO','MZ N LOTE 9','3044672390',4);

INSERT INTO raza (nmid_especie, nombre_raza)
VALUES (1, 'Conejo Belier'),
       (2, 'Conejo Mini Lop'),
       (3, 'Labrador'),
       (4, 'Lobo Siveriano');

INSERT INTO mascota (nombre_mascota, nmid_especie, nmid_raza, f_naci, nmid_propietario, f_reg)
VALUES ('Oriona', 3, 1, NOW(), 1, NOW());
