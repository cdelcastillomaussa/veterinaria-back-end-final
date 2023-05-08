package com.softcaribbean.veterinaria.manager;

import com.softcaribbean.veterinaria.dto.Mascota;
import com.softcaribbean.veterinaria.exception.MgrException;

import java.util.List;
import java.util.Map;

public interface MascotaMGR {
    void saveOrInsert(Mascota pet) throws MgrException;

    void delete(int nmid) throws  MgrException;

    List<Map<String,Object>> getAll() throws  MgrException;
}
