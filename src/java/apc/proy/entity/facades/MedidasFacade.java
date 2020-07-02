/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.entity.facades;

import apc.proy.entity.Medidas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author desa
 */
@Stateless
public class MedidasFacade extends AbstractFacade<Medidas> implements MedidasFacadeLocal {

    @PersistenceContext(unitName = "ProyectoAbrilPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedidasFacade() {
        super(Medidas.class);
    }
    
    @Override
    public List<Medidas> findAllMed() {
        List<Medidas> tmedidas;

        try{
            tmedidas = em.createQuery("SELECT m FROM Medidas m").getResultList();
            
            return tmedidas;
            
        }catch(Exception e){
            
            return null;
        }
    }
    
}
