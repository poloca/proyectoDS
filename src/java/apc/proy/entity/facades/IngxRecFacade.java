/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.entity.facades;

import apc.proy.entity.IngxRec;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author desa
 */
@Stateless
public class IngxRecFacade extends AbstractFacade<IngxRec> implements IngxRecFacadeLocal {

    @PersistenceContext(unitName = "ProyectoAbrilPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngxRecFacade() {
        super(IngxRec.class);
    }
    
    @Override
    public List<IngxRec> findIRByReceta(int recid){
        List<IngxRec> ixr;
        
        try {
             ixr = em.createQuery("SELECT i FROM IngxRec i WHERE i.idReceta = :idReceta")
                    .setParameter(":idReceta", recid).getResultList();
                     
             return ixr;

        } catch (Exception e) {
            return null;
        }
    }
    
}
