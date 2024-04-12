CREATE TABLE IF NOT EXISTS propietario (
	nmid SERIAL,
	tipo_doc varchar(50) NOT NULL,
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
    nmid_raza INT NOT NULL, -- referencia hacia la tabla raza
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

CREATE TABLE IF NOT EXISTS raza (
    nmid SERIAL,
    nmid_especie INT NOT NULL,
    nombre_raza varchar(25) NOT NULL,
    PRIMARY KEY(nmid)
)

-- Relacion Propietario - Ciudad
ALTER TABLE propietario ADD FOREIGN KEY (nmid_ciudad) REFERENCES ciudad(nmid);

--Relacion Mascota - Especie
ALTER TABLE mascota ADD FOREIGN KEY (nmid_especie) REFERENCES especie(nmid);

--Relacion Mascota - Raza
ALTER TABLE mascota ADD FOREIGN KEY (nmid_raza) REFERENCES raza(nmid);

--Relacion Mascota - Propietario
ALTER TABLE mascota ADD FOREIGN KEY (nmid_propietario) REFERENCES propietario(nmid);

--Relacion Raza - Especie
ALTER TABLE raza ADD FOREIGN KEY (nmid_especie) REFERENCES especie(nmid);