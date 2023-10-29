package com.softcaribbean.veterinaria.dao;

import com.softcaribbean.veterinaria.dto.Raza;
import com.softcaribbean.veterinaria.exception.DAOException;
import com.softcaribbean.veterinaria.mapper.RazaMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class RazaDAOImpl implements RazaDAO {
    private JdbcTemplate jdbcTemplate;
    public RazaDAOImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Map<String, Object>> getRazasByEspecie(int nmid) throws DAOException {
        String SELECT = "SELECT r.nmid, r.nombre_raza FROM raza r WHERE r.nmid_especie = ?";
        List<Map<String, Object>> listRazas;
        try {
            listRazas = jdbcTemplate.queryForList(SELECT);
        } catch (Exception e){
            throw new DAOException(e);
        }
        return listRazas;
    }
}
