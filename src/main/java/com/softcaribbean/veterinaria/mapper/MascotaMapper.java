package com.softcaribbean.veterinaria.mapper;

import com.softcaribbean.veterinaria.dto.Mascota;
import com.softcaribbean.veterinaria.dto.Propietario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MascotaMapper implements RowMapper<Mascota> {
    @Override
    public Mascota mapRow(ResultSet rs, int rowNum) throws SQLException {
        Mascota resultmascota = new Mascota();
        Propietario obj = new Propietario();
        resultmascota.setNombre_mascota(rs.getString("nombre_mascota"));
        resultmascota.setNmid_raza(rs.getInt("nmid_raza"));
        resultmascota.setF_naci(rs.getDate("f_naci"));
        obj.setNmid(rs.getInt("nmid_propietario"));
        resultmascota.setPropietario(obj);
        return resultmascota;
    }

}
