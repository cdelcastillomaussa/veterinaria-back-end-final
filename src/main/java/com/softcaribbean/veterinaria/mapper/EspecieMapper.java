package com.softcaribbean.veterinaria.mapper;

import com.softcaribbean.veterinaria.dto.Especie;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EspecieMapper implements RowMapper<Especie> {
    @Override
    public Especie mapRow(ResultSet rs, int rowNum) throws SQLException {
        Especie resultespecie = new Especie();
        resultespecie.setNombre_especie(rs.getString("nombre_especie"));
        return resultespecie;
    }

}
