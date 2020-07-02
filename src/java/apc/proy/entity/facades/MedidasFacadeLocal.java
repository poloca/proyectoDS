/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.entity.facades;

import apc.proy.entity.Medidas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author desa
 */
@Local
public interface MedidasFacadeLocal {

    void create(Medidas medidas);

    void edit(Medidas medidas);

    void remove(Medidas medidas);

    Medidas find(Object id);

    List<Medidas> findAll();
    
    List<Medidas> findRange(int[] range);

    int count();
    
    public List<Medidas> findAllMed();
    
}
