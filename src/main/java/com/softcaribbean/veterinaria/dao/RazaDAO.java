package com.softcaribbean.veterinaria.dao;

import com.softcaribbean.veterinaria.dto.Raza;
import com.softcaribbean.veterinaria.exception.DAOException;

import java.util.List;
import java.util.Map;

public interface RazaDAO {
    List<Map<String, Object>> getRazasByEspecie(int nmid) throws DAOException;
}
