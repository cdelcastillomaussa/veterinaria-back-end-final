package com.softcaribbean.veterinaria.services;

import com.softcaribbean.veterinaria.exception.MgrException;
import com.softcaribbean.veterinaria.exception.ServiceException;
import com.softcaribbean.veterinaria.manager.CiudadMGR;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CiudadServiceImpl implements CiudadService {
    private CiudadMGR ciudadMGR;
    public CiudadServiceImpl(CiudadMGR ciudadMGR) {

        this.ciudadMGR = ciudadMGR;
    }
    public List<Map<String,Object>> mostrarCiudades() throws ServiceException {
        List<Map<String,Object>> ciudades;

        try {
            ciudades = ciudadMGR.getAll();
        } catch (MgrException e) {
            throw new ServiceException(e);
        }catch (Exception ex) {
            throw new ServiceException(ex);
        }
        return ciudades;
    }
}
