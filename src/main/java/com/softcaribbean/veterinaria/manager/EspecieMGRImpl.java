package com.softcaribbean.veterinaria.manager;

import com.softcaribbean.veterinaria.dao.EspecieDAO;
import com.softcaribbean.veterinaria.dto.Especie;
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

    public void saveOrInsert(Especie esp) throws MgrException {
        try {
            Especie especie = especieDAO.getById(esp.getNmid());
            if(especie == null){
                System.out.println("Especie guardada exitosamente");
                especieDAO.insert(esp);
            }else {
                System.out.println("Especie actualizada exitosamente");
                especieDAO.update(esp);
            }
        } catch (DAOException e) {
            throw new MgrException(e);
        }catch (Exception ex){
            throw new MgrException(ex);
        }
    }

    public void delete(int nmid) throws  MgrException {
        try {
            Especie especie = especieDAO.getById(nmid);
            if(especie == null){
                System.out.println("El tomador no existe");
            }else {
                especieDAO.delete(nmid);
            }
        } catch (DAOException e) {
            throw new MgrException(e);
        }catch (Exception ex){
            throw new MgrException(ex);
        }
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
