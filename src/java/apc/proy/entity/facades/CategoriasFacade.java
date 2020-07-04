/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.entity.facades;

import apc.proy.entity.Categorias;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author desa
 */
@Stateless
public class CategoriasFacade extends AbstractFacade<Categorias> implements CategoriasFacadeLocal {

    @PersistenceContext(unitName = "ProyectoAbrilPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriasFacade() {
        super(Categorias.class);
    }
    
    
    @Override
    public List<Categorias> findAllCat() {
        List<Categorias> tcategorias;

        try {
            tcategorias = em.createQuery("SELECT c FROM Categorias c").getResultList();

            return tcategorias;
            
        } catch (Exception e) {
            
            return null;
        }
    }
    
    @Override
    public String findCategoriaByid(int catid){
        String catNom;
        
        try {
            catNom= (String) em.createQuery("SELECT c.nombrec FROM Categorias c WHERE c.idCategoria = :idCategoria")
                    .setParameter("idCategoria", catid)
                    .getSingleResult();

            return catNom;

        } catch (Exception e) {
            return null;
        }
    }
    
}
