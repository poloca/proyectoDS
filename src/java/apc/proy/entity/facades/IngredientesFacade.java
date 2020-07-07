/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.entity.facades;

import apc.proy.entity.Ingredientes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author desa
 */
@Stateless
public class IngredientesFacade extends AbstractFacade<Ingredientes> implements IngredientesFacadeLocal {

    @PersistenceContext(unitName = "ProyectoAbrilPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngredientesFacade() {
        super(Ingredientes.class);
    }
    
    @Override
    public List<Ingredientes> findAllIng() {
        List<Ingredientes> tingredientes;

        try{
            tingredientes = em.createQuery("SELECT i FROM Ingredientes i").getResultList();
            
            return tingredientes;
            
        }catch(Exception e){
            
            return null;
        }
    }
    
    @Override
    public Ingredientes findIngredienteNombre(String nombrei) {

        Ingredientes Ingrediente;

        try {
            Ingrediente = (Ingredientes) em.createQuery("SELECT i FROM Ingredientes i WHERE i.nombrei = :nombrei")
                    .setParameter("nombrei", nombrei)
                    .getSingleResult();

            return Ingrediente;

        } catch (Exception e) {
            return null;
        }
    }
    
    
}
