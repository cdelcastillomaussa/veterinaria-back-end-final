package com.softcaribbean.veterinaria.manager;

import com.softcaribbean.veterinaria.exception.MgrException;

import java.util.List;
import java.util.Map;

public interface EspecieMGR {
    List<Map<String,Object>> getAll() throws  MgrException;
}
