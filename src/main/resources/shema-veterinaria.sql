CREATE TABLE IF NOT EXISTS propietario (
	nmid SERIAL,
	tipo_doc varchar(20) NOT NULL,
	documento varchar(15) NOT NULL,
	nombre_propietario varchar(35) NOT NULL, --nombre completo
	direccion varchar(40) NOT NULL,
	telefono varchar(20) NOT NULL,
	nmid_ciudad INT NOT NULL, -- FOREIGN KEY ciudades
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
	nmid_especie INT NOT NULL, -- referencia hacia la tabla especie
    raza varchar(40) NOT NULL,
	f_naci date default null,
	nmid_propietario INT NOT NULL, -- referencia hacia la tabla Propietario
	f_reg date,
	PRIMARY KEY (nmid)
);

CREATE TABLE IF NOT EXISTS especie (
	nmid SERIAL,
	nombre_especie varchar(20) NOT NULL,
	PRIMARY KEY (nmid)
);

-- Relacion Propietario - Ciudad
ALTER TABLE propietario ADD FOREIGN KEY (nmid_ciudad) REFERENCES ciudad(nmid);

--Relacion Mascota - raza
ALTER TABLE mascota ADD FOREIGN KEY (nmid_especie) REFERENCES especie(nmid);

--Relacion Mascota - Propietario
ALTER TABLE mascota ADD FOREIGN KEY (nmid_propietario) REFERENCES propietario(nmid);
