package com.softcaribbean.veterinaria.dao;

import com.softcaribbean.veterinaria.dto.Especie;
import com.softcaribbean.veterinaria.exception.DAOException;
import com.softcaribbean.veterinaria.mapper.EspecieMapper;
import org.springframework.dao.DataAccessException;
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
    public void insert(Especie especie) throws DAOException {
        String INSERT = "INSERT INTO public.especie(\n" +
                "\tnombre_especie)\n" +
                "\tVALUES (?);";
        jdbcTemplate.update(INSERT,
                especie.getNombre_especie());
    }
    public void update(Especie especie) throws DAOException {
        String UPDATE = "UPDATE public.especie\n" +
                "\tSET nombre_especie=? \n" +
                "\tWHERE nmid=?;";
        jdbcTemplate.update(UPDATE,
                especie.getNombre_especie(),
                especie.getNmid());
    }
    public void delete(int nmid) throws DAOException {
        String DELETE = "DELETE FROM especie WHERE nmid = ?";
        try {
            jdbcTemplate.update(DELETE, nmid);
        }catch (Exception e) {
            throw new DAOException(e);
        }
    }
    public Especie getById(int nmid) throws DAOException {
        String SELECTBYID = "SELECT \n" +
                "E.nmid,\n" +
                "E.nombre_especie\n" +
                "FROM especie E WHERE E.nmid = ?";
        Especie especie = null;
        try {
            especie = jdbcTemplate.queryForObject(SELECTBYID, new Object[]{nmid}, new EspecieMapper());
        }catch(DataAccessException ex){

        }
        return especie;
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
