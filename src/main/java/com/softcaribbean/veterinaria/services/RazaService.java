package com.softcaribbean.veterinaria.services;

import com.softcaribbean.veterinaria.exception.MgrException;
import com.softcaribbean.veterinaria.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface RazaService {
    List<Map<String,Object>> getRazasByEspecie(int nmid) throws ServiceException;
}
