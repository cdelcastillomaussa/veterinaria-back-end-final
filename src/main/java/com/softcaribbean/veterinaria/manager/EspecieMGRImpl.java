package com.softcaribbean.veterinaria.manager;

import com.softcaribbean.veterinaria.dao.EspecieDAO;
import com.softcaribbean.veterinaria.exception.DAOException;
import com.softcaribbean.veterinaria.exception.MgrException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public class EspecieMGRImpl implements EspecieMGR {
    private EspecieDAO especieDAO;

    public EspecieMGRImpl(EspecieDAO especieDAO) {
        this.especieDAO = especieDAO;
    }

    public List<Map<String,Object>> getAll() throws  MgrException {
        List<Map<String,Object>>  especies;
        try {
            especies = especieDAO.getAll();
        } catch (DAOException e){
            throw new MgrException(e);
        }catch (Exception ex){
            throw new MgrException(ex);
        }
        return especies;
    }

}
