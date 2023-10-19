INSERT INTO especie (nmid, nombre_especie)
VALUES 	  (1 , 'Perros' ),
          (2 , 'Gatos' ),
          (3 , 'Conejos' ),
          (4 , 'Cobayas' ),
          (5 , 'Hamsters' ),
          (6 , 'Canarios' ),
          (7 , 'Loros' ),
          (8 , 'Peces ornamentales' ),
          (9 , 'Tortugas' ),
          (10 , 'Serpientes' );

INSERT INTO ciudad (nmid, nombre_ciudad, codigo)
VALUES	(1, 'Bogotá D.C.', 11001),
          (2, 'Medellín', 05001),
          (3, 'Barranquilla', 08001),
          (4, 'Montería', 23001),
          (5, 'Cereté', 23162),
          (6, 'Sahagún', 23672),
          (7, 'Planeta Rica', 23675),
          (8, 'Tierralta', 23807),
          (9, 'Lorica', 23417),
          (10, 'Montelíbano', 23555);


INSERT INTO mascota (nombre_mascota, nmid_especie, nmid_raza , f_naci, nmid_propietario, f_reg)
VALUES ('Oriona', 3, 5, '2007-09-20', 1, NOW())