/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.entity.facades;

import apc.proy.entity.Receta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author desa
 */
@Stateless
public class RecetaFacade extends AbstractFacade<Receta> implements RecetaFacadeLocal {

    @PersistenceContext(unitName = "ProyectoAbrilPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RecetaFacade() {
        super(Receta.class);
    }
    
    @Override
    public Receta findRecetaByid(int idreceta){
        Receta Rec;
        
        try {
            Rec = (Receta) em.createQuery("SELECT r FROM Receta r WHERE r.idReceta = :idReceta")
                    .setParameter("idReceta", idreceta)
                    .getSingleResult();

            return Rec;

        } catch (Exception e) {
            return null;
        }
    }
    
}
