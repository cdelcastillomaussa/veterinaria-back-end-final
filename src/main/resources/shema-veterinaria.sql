CREATE TABLE IF NOT EXISTS propietario (
	nmid SERIAL,
	tipo_doc varchar(20) NOT NULL,
	documento varchar(15) NOT NULL,
	nombre_propietario varchar(35) NOT NULL, --nombre completo
	nmid_ciudad INT NOT NULL, -- FOREIGN KEY ciudades
	direccion varchar(40) NOT NULL,
	telefono varchar(20) NOT NULL,
	PRIMARY KEY (nmid)
);

CREATE TABLE IF NOT EXISTS ciudad (
	nmid SERIAL,
	nombre_ciudad varchar(25) NOT null,
	codigo int not null,
	PRIMARY KEY (nmid)
);

CREATE TABLE IF NOT EXISTS mascota (
	nmid SERIAL,
	nombre_mascota varchar(20) NOT NULL,
	nmid_raza INT NOT NULL, -- referencia hacia la tabla raza
	f_naci date default null,
	nmid_propietario INT NOT NULL, -- referencia hacia la tabla propietario
	f_reg timestamp,
	PRIMARY KEY (nmid)
);

CREATE TABLE IF NOT EXISTS raza (
	nmid SERIAL,
	nombre_raza varchar(50),
	nmid_especie INT NOT NULL, --referencia hacia la tabla especie
	PRIMARY KEY (nmid)
);

CREATE TABLE IF NOT EXISTS especie (
	nmid SERIAL,
	nombre_especie varchar(20) NOT NULL,
	PRIMARY KEY (nmid)
);

-- Relacion propietario - ciudad
ALTER TABLE propietario ADD FOREIGN KEY (nmid_ciudad) REFERENCES ciudad(nmid);

--Relacion raza - especie
ALTER TABLE raza ADD FOREIGN KEY (nmid_especie) REFERENCES especie(nmid);

--Relacion mascota - raza
ALTER TABLE mascota ADD FOREIGN KEY (nmid_raza) REFERENCES raza(nmid);

--Relacion mascota - propietario 
ALTER TABLE mascota ADD FOREIGN KEY (nmid_propietario) REFERENCES propietario(nmid);
