package com.softcaribbean.veterinaria.services;

import com.softcaribbean.veterinaria.exception.MgrException;
import com.softcaribbean.veterinaria.exception.ServiceException;
import com.softcaribbean.veterinaria.manager.RazaMGR;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Service
@Transactional
public class RazaServiceImpl implements RazaService {
    private RazaMGR razaMGR;
    public RazaServiceImpl(RazaMGR razaMGR){
        this.razaMGR = razaMGR;
    }
    @Override
    public List<Map<String, Object>> getRazasByEspecie(int nmid) throws ServiceException {
        List<Map<String,Object>> listRazas;
        try {
            listRazas = razaMGR.getRazasByEspecie(nmid);
        } catch (MgrException e) {
            throw new ServiceException(e);
        }catch (Exception ex) {
            throw new ServiceException(ex);
        }
        return listRazas;
    }
}
