package com.softcaribbean.veterinaria.manager;

import com.softcaribbean.veterinaria.dto.Propietario;
import com.softcaribbean.veterinaria.exception.MgrException;

import java.util.List;
import java.util.Map;

public interface PropietarioMGR {
    void saveOrInsert(Propietario prop) throws MgrException;

    void delete(int nmid) throws  MgrException;

    List<Map<String,Object>> getAll() throws  MgrException;
}
