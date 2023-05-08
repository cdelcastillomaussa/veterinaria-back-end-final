package com.softcaribbean.veterinaria.dao;

import com.softcaribbean.veterinaria.dto.Mascota;
import com.softcaribbean.veterinaria.exception.DAOException;
import com.softcaribbean.veterinaria.mapper.MascotaMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class MascotaDAOImpl implements MascotaDAO {
    private JdbcTemplate jdbcTemplate;
    public MascotaDAOImpl(DataSource dataSource) {

        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public void insert(Mascota mascota) throws DAOException {
        String INSERT = "INSERT INTO public.mascota(\n" +
                "\tnombre_mascota, nmid_especie, raza, f_naci, nmid_propietario, f_reg)\n" +
                "\tVALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(INSERT,
                mascota.getNombre_mascota(),
                mascota.getEspecie().getNmid(),
                mascota.getRaza(),
                mascota.getF_naci(),
                mascota.getPropietario().getNmid(),
                mascota.getF_reg());
    }
    public void update(Mascota mascota) throws DAOException {
        String UPDATE = "UPDATE public.mascota\n" +
                "\tSET nombre_mascota=?, nmid_especie=?, raza=?, f_naci=?, nmid_propietario=?,  f_reg=? \n" +
                "\tWHERE nmid=?";
        jdbcTemplate.update(UPDATE,
                mascota.getNombre_mascota(),
                mascota.getEspecie().getNmid(),
                mascota.getRaza(),
                mascota.getF_naci(),
                mascota.getPropietario().getNmid(),
                mascota.getF_reg(),
                mascota.getNmid()
        );
    }
    public void delete(int nmid) throws DAOException {
        String DELETE = "DELETE FROM mascota WHERE nmid = ?";
        try {
            jdbcTemplate.update(DELETE, nmid);
        }catch (Exception e) {
            throw new DAOException(e);
        }
    }
    public Mascota getById(int nmid) throws DAOException {
        String SELECTBYID = "SELECT \n" +
                "M.nmid, \n" +
                "M.nombre_mascota, \n" +
                "M.nmid_especie, \n" +
                "M.raza, \n" +
                "M.f_naci, \n" +
                "M.nmid_propietario, \n" +
                "M.f_reg \n" +
                "FROM public.mascota M WHERE M.nmid = ? ";
        Mascota mascota = null;
        try {
            mascota = jdbcTemplate.queryForObject(SELECTBYID, new Object[]{nmid}, new MascotaMapper());
        }catch(DataAccessException ex){

        }
        return mascota;
    }
    public List<Map<String, Object>> getAll() throws DAOException {
        String SELECT = "SELECT \n" +
                "M.nmid,\n" +
                "M.nombre_mascota,\n" +
                "E.nombre_especie,\n" +
                "M.raza,\n" +
                "M.f_naci as f_naci_mascota,\n" +
                "P.nombre_propietario,\n" +
                "M.f_reg\n" +
                "FROM mascota M INNER JOIN especie E ON M.nmid_especie = E.nmid\n" +
                "INNER JOIN propietario P ON M.nmid_propietario = P.nmid";
        List<Map<String,Object>> listMascota;
        try {
            listMascota = jdbcTemplate.queryForList(SELECT);

        } catch (Exception e) {
            throw new DAOException(e);
        }
        return listMascota;
    }
}
