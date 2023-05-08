package com.softcaribbean.veterinaria.dao;

import com.softcaribbean.veterinaria.dto.Propietario;
import com.softcaribbean.veterinaria.exception.DAOException;
import com.softcaribbean.veterinaria.mapper.PropietarioMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class PropietarioDAOImpl implements PropietarioDAO {
    private JdbcTemplate jdbcTemplate;
    public PropietarioDAOImpl(DataSource dataSource) {

        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public void insert(Propietario propietario) throws DAOException {
        String INSERT = "INSERT INTO public.propietario(\n" +
                "\ttipo_doc, documento, nombre_propietario, direccion, telefono, nmid_ciudad)\n" +
                "\tVALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(INSERT,
                propietario.getTipo_doc(),
                propietario.getDocumento(),
                propietario.getNombre_propietario(),
                propietario.getDireccion(),
                propietario.getTelefono(),
                propietario.getCiudad().getNmid());
    }
    public void update(Propietario propietario) throws DAOException {
        String UPDATE = "UPDATE public.propietario\n" +
                "\tSET tipo_doc=?, documento=?, nombre_propietario=?, direccion=?, telefono=?,  nmid_ciudad=? \n" +
                "\tWHERE nmid=?";
        jdbcTemplate.update(UPDATE,
                propietario.getTipo_doc(),
                propietario.getDocumento(),
                propietario.getNombre_propietario(),
                propietario.getDireccion(),
                propietario.getTelefono(),
                propietario.getCiudad().getNmid(),
                propietario.getNmid()
        );
    }
    public void delete(int nmid) throws DAOException {
        String DELETE = "DELETE FROM propietario WHERE nmid = ?";
        try {
            jdbcTemplate.update(DELETE, nmid);
        }catch (Exception e) {
            throw new DAOException(e);
        }
    }
    public Propietario getById(int nmid) throws DAOException {
        String SELECTBYID = "SELECT \n" +
                "P.nmid, \n" +
                "P.tipo_doc, \n" +
                "P.documento, \n" +
                "P.nombre_propietario, \n" +
                "p.direccion, \n" +
                "P.telefono, \n" +
                "P.nmid_ciudad \n" +
                "FROM public.propietario P WHERE P.nmid = ? ";
        Propietario propietario = null;
        try {
            propietario = jdbcTemplate.queryForObject(SELECTBYID, new Object[]{nmid}, new PropietarioMapper());
        }catch(DataAccessException ex){

        }
        return propietario;
    }
    public List<Map<String, Object>> getAll() throws DAOException {
        String SELECT = "SELECT \n" +
                "P.nmid, \n" +
                "P.tipo_doc, \n" +
                "P.documento, \n" +
                "P.nombre_propietario,\n" +
                "P.direccion,\n" +
                "P.telefono,\n" +
                "C.nmid as nmid_ciudad,\n" +
                "C.nombre_ciudad,\n" +
                "C.codigo\n" +
                "FROM propietario P INNER JOIN ciudad C ON P.nmid_ciudad = C.nmid ";
        List<Map<String,Object>> listPropietario;
        try {
            listPropietario = jdbcTemplate.queryForList(SELECT);

        } catch (Exception e) {
            throw new DAOException(e);
        }
        return listPropietario;
    }

}
