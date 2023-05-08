package com.softcaribbean.veterinaria.services;

import com.softcaribbean.veterinaria.dto.Especie;
import com.softcaribbean.veterinaria.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface EspecieService {
    void createEspecie(Especie especie) throws ServiceException;

    void eliminarEspecie(int nmid) throws ServiceException;

    List<Map<String,Object>> mostrarEspecies() throws ServiceException;
}
