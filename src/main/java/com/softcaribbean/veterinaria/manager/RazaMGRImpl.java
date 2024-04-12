package com.softcaribbean.veterinaria.manager;

import com.softcaribbean.veterinaria.dao.RazaDAO;
import com.softcaribbean.veterinaria.exception.DAOException;
import com.softcaribbean.veterinaria.exception.MgrException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public class RazaMGRImpl implements RazaMGR{
    private RazaDAO razaDAO;
    public RazaMGRImpl(RazaDAO razaDAO){
        this.razaDAO = razaDAO;
    }
    @Override
    public List<Map<String, Object>> getRazasByEspecie(int nmid) throws MgrException {
        List<Map<String,Object>>  listRazas;
        try {
            listRazas = razaDAO.getRazasByEspecie(nmid);
        } catch (DAOException e){
            throw new MgrException(e);
        }catch (Exception ex){
            throw new MgrException(ex);
        }
        return listRazas;
    }
}
