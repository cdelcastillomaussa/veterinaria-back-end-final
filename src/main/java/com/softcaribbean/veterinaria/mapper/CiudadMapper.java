package com.softcaribbean.veterinaria.mapper;

import com.softcaribbean.veterinaria.dto.Ciudad;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CiudadMapper implements RowMapper<Ciudad> {
    @Override
    public Ciudad mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ciudad resultciu = new Ciudad();
        resultciu.setNombre_ciudad(rs.getString("nombre_ciudad"));
        resultciu.setCodigo(rs.getInt("codigo"));
        return resultciu;
    }

}
