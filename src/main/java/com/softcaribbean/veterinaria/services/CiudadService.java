package com.softcaribbean.veterinaria.services;

import com.softcaribbean.veterinaria.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface CiudadService {
    List<Map<String,Object>> mostrarCiudades() throws ServiceException;

}
