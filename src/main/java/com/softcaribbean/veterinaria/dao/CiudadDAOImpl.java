package com.softcaribbean.veterinaria.dao;


import com.softcaribbean.veterinaria.exception.DAOException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
@Repository
public class CiudadDAOImpl implements CiudadDAO {
    private JdbcTemplate jdbcTemplate;

    public CiudadDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Map<String, Object>> getAll() throws DAOException {
        String SELECT = "SELECT nmid, nombre_ciudad, codigo FROM ciudad";
        List<Map<String,Object>> listCiudad;
        try {
            listCiudad = jdbcTemplate.queryForList(SELECT);

        } catch (Exception e) {
            throw new DAOException(e);
        }
        return listCiudad;
    }
}
