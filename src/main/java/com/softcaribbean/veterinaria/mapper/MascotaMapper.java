package com.softcaribbean.veterinaria.mapper;

import com.softcaribbean.veterinaria.dto.Especie;
import com.softcaribbean.veterinaria.dto.Mascota;
import com.softcaribbean.veterinaria.dto.Propietario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MascotaMapper implements RowMapper<Mascota> {
    @Override
    public Mascota mapRow(ResultSet rs, int rowNum) throws SQLException {
        Mascota resultmascota = new Mascota();
        Especie especie = new Especie();
        Propietario propietario = new Propietario();

        resultmascota.setNombre_mascota(rs.getString("nombre_mascota"));
        especie.setNmid(rs.getInt("nmid_especie"));
        resultmascota.setEspecie(especie);
        resultmascota.setRaza(rs.getString("raza"));
        resultmascota.setF_naci(rs.getDate("f_naci"));
        propietario.setNmid(rs.getInt("nmid_propietario"));
        resultmascota.setPropietario(propietario);
        resultmascota.setF_reg(rs.getDate("f_reg"));

        return resultmascota;
    }

}
