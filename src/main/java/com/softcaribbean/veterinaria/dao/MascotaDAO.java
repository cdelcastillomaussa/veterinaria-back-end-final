package com.softcaribbean.veterinaria.dao;

import com.softcaribbean.veterinaria.dto.Mascota;
import com.softcaribbean.veterinaria.exception.DAOException;

import java.util.List;
import java.util.Map;

public interface MascotaDAO {
    void insert(Mascota mascota) throws DAOException;
    void update(Mascota mascota) throws DAOException;
    void delete(int nmid) throws DAOException;
    Mascota getById(int nmid) throws DAOException;

    List<Map<String,Object>> getAll() throws DAOException;
}
