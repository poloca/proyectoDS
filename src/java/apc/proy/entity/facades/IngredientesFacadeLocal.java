/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.entity.facades;

import apc.proy.entity.Ingredientes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author desa
 */
@Local
public interface IngredientesFacadeLocal {

    void create(Ingredientes ingredientes);

    void edit(Ingredientes ingredientes);

    void remove(Ingredientes ingredientes);

    Ingredientes find(Object id);

    List<Ingredientes> findAll();
    
    List<Ingredientes> findRange(int[] range);

    int count();
    
    public List<Ingredientes> findAllIng();
    
}
