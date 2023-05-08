package com.softcaribbean.veterinaria.mapper;

import com.softcaribbean.veterinaria.dto.Raza;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RazaMapper implements RowMapper<Raza>  {
    @Override
    public Raza mapRow(ResultSet rs, int rowNum) throws SQLException {
        Raza resultraza = new Raza();
        resultraza.setNombre_raza(rs.getString("nombre_raza"));
        resultraza.setNmid_especie(rs.getInt("nmid_especie"));
        return resultraza;
    }
}
