package com.softcaribbean.veterinaria.mapper;

import com.softcaribbean.veterinaria.dto.Ciudad;
import com.softcaribbean.veterinaria.dto.Propietario;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PropietarioMapper implements RowMapper<Propietario> {
    @Override
    public Propietario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Propietario resultprop = new Propietario();
        Ciudad ciudad = new Ciudad();
        resultprop.setTipo_doc(rs.getString("tipo_doc"));
        resultprop.setDocumento(rs.getString("documento"));
        resultprop.setNombre_propietario(rs.getString("nombre_propietario"));
        resultprop.setDireccion(rs.getString("direccion"));
        resultprop.setTelefono(rs.getString("telefono"));
        ciudad.setNmid(rs.getInt("nmid_ciudad"));
        resultprop.setCiudad(ciudad);
        return resultprop;
    }
}
