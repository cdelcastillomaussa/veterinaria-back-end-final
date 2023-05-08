package com.softcaribbean.veterinaria.dao;

import com.softcaribbean.veterinaria.exception.DAOException;

import java.util.List;
import java.util.Map;

public interface EspecieDAO {
    List<Map<String,Object>> getAll() throws DAOException;
}
