/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.entity.facades;

import apc.proy.entity.Categorias;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author desa
 */
@Local
public interface CategoriasFacadeLocal {

    void create(Categorias categorias);

    void edit(Categorias categorias);

    void remove(Categorias categorias);

    Categorias find(Object id);

    List<Categorias> findAll();
    
    List<Categorias> findRange(int[] range);

    int count();
    
    public List<Categorias> findAllCat();
    
    public String findCategoriaByid(int catid);
    
}
