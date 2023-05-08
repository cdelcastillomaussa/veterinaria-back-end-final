package com.softcaribbean.veterinaria.dao;

import com.softcaribbean.veterinaria.dto.Propietario;
import com.softcaribbean.veterinaria.exception.DAOException;

import java.util.List;
import java.util.Map;

public interface PropietarioDAO {
    void insert(Propietario propietario) throws DAOException;
    void update(Propietario propietario) throws DAOException;
    void delete(int nmid) throws DAOException;
    Propietario getById(int nmid) throws DAOException;

    List<Map<String,Object>> getAll() throws DAOException;
}
