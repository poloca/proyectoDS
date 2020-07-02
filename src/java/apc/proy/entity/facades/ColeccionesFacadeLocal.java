/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.entity.facades;

import apc.proy.entity.Colecciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author desa
 */
@Local
public interface ColeccionesFacadeLocal {

    void create(Colecciones colecciones);

    void edit(Colecciones colecciones);

    void remove(Colecciones colecciones);

    Colecciones find(Object id);

    List<Colecciones> findAll();
    
    List<Colecciones> findRange(int[] range);

    int count();
    
    public List<Colecciones> findByUN(int iduser);
    
}
