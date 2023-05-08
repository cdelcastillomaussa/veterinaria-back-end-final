package com.softcaribbean.veterinaria.dao;

import com.softcaribbean.veterinaria.dto.Especie;
import com.softcaribbean.veterinaria.exception.DAOException;

import java.util.List;
import java.util.Map;

public interface EspecieDAO {
    void insert(Especie especie) throws DAOException;
    void update(Especie especie) throws DAOException;
    void delete(int nmid) throws DAOException;
    Especie getById(int nmid) throws DAOException;

    List<Map<String,Object>> getAll() throws DAOException;
}
