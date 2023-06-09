package com.softcaribbean.veterinaria.dao;

import com.softcaribbean.veterinaria.exception.DAOException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class EspecieDAOImpl implements EspecieDAO {
    private JdbcTemplate jdbcTemplate;

    public EspecieDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Map<String, Object>> getAll() throws DAOException {
        String SELECT = "SELECT nmid, nombre_especie FROM especie";
        List<Map<String,Object>> listEspecie;
        try {
            listEspecie = jdbcTemplate.queryForList(SELECT);

        } catch (Exception e) {
            throw new DAOException(e);
        }
        return listEspecie;
    }



}
