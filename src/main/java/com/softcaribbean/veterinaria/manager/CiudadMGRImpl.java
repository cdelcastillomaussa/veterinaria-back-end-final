package com.softcaribbean.veterinaria.manager;

import com.softcaribbean.veterinaria.dao.CiudadDAO;
import com.softcaribbean.veterinaria.dao.EspecieDAO;
import com.softcaribbean.veterinaria.exception.DAOException;
import com.softcaribbean.veterinaria.exception.MgrException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public class CiudadMGRImpl implements CiudadMGR{
    private CiudadDAO ciudadDAO;

    public CiudadMGRImpl(CiudadDAO ciudadDAO) {
        this.ciudadDAO = ciudadDAO;
    }

    public List<Map<String,Object>> getAll() throws MgrException {
        List<Map<String,Object>>  ciudades;
        try {
            ciudades = ciudadDAO.getAll();
        } catch (DAOException e){
            throw new MgrException(e);
        }catch (Exception ex){
            throw new MgrException(ex);
        }
        return ciudades;
    }
}
