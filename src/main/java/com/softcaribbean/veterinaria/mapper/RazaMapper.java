package com.softcaribbean.veterinaria.mapper;

import com.softcaribbean.veterinaria.dto.Especie;
import com.softcaribbean.veterinaria.dto.Razas;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RazaMapper implements RowMapper<Razas> {
    @Override
    public Razas mapRow(ResultSet rs, int rowNum) throws SQLException {
            Especie especie = new Especie();
            Razas raza = new Razas();

            especie.setNmid(rs.getInt("nmid_especie"));
            raza.setEspecie(especie);
            raza.setNombre_raza(rs.getString("nombre_raza"));

            return raza;
    }
}
