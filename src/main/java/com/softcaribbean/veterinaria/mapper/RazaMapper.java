package com.softcaribbean.veterinaria.mapper;

import com.softcaribbean.veterinaria.dto.Especie;
import com.softcaribbean.veterinaria.dto.Raza;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RazaMapper implements RowMapper<Raza> {
    @Override
    public Raza mapRow(ResultSet rs, int rowNum) throws SQLException {
            Raza raza = new Raza();
            Especie especie = new Especie();
            raza.setNombre_raza(rs.getString("nombre_raza"));
            especie.setNmid(rs.getInt("nmid_especie"));
            raza.setEspecie(especie);
            return raza;
    }
}
