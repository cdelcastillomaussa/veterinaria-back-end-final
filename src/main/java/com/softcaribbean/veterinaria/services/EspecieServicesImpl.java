package com.softcaribbean.veterinaria.services;

import com.softcaribbean.veterinaria.dto.Especie;
import com.softcaribbean.veterinaria.exception.MgrException;
import com.softcaribbean.veterinaria.exception.ServiceException;
import com.softcaribbean.veterinaria.manager.EspecieMGR;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Service
@Transactional
public class EspecieServicesImpl implements EspecieService {
    private EspecieMGR especieMGR;
    public EspecieServicesImpl(EspecieMGR especieMGR) {

        this.especieMGR = especieMGR;
    }
    public void createEspecie(Especie esp) throws ServiceException {

        try {
            especieMGR.saveOrInsert(esp);
        } catch (MgrException e) {
            throw new ServiceException(e);
        }catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    public void eliminarEspecie(int nmid) throws ServiceException {
        try {
            especieMGR.delete(nmid);
        } catch (MgrException e) {
            throw new ServiceException(e);
        }catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    public List<Map<String,Object>> mostrarEspecies() throws ServiceException {
        List<Map<String,Object>> especies;

        try {
            especies = especieMGR.getAll();
        } catch (MgrException e) {
            throw new ServiceException(e);
        }catch (Exception ex) {
            throw new ServiceException(ex);
        }
        return especies;
    }

}
