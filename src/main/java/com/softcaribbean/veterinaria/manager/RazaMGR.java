package com.softcaribbean.veterinaria.manager;

import com.softcaribbean.veterinaria.exception.MgrException;

import java.util.List;
import java.util.Map;

public interface RazaMGR {
    List<Map<String,Object>> getRazasByEspecie(int nmid) throws MgrException;
}
