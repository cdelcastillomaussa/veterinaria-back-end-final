package com.softcaribbean.veterinaria.services;

import com.softcaribbean.veterinaria.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface EspecieService {
    List<Map<String,Object>> mostrarEspecies() throws ServiceException;
}
