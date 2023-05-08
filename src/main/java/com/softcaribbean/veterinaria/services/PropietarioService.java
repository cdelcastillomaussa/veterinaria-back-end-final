package com.softcaribbean.veterinaria.services;

import com.softcaribbean.veterinaria.dto.Propietario;
import com.softcaribbean.veterinaria.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface PropietarioService {
    void createPropietario(Propietario pro) throws ServiceException;

    void eliminarPropietarios(int nmid) throws ServiceException;

    List<Map<String,Object>> mostrarPropietarios() throws ServiceException;
}
