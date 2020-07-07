/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.entity.facades;

import apc.proy.entity.IngxRec;
import apc.proy.model.dto.IRNombres;
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
                    .setParameter("idReceta", recid)
                    .getResultList();
                     
             return ixr;

        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public List<IRNombres> findIRNamesByReceta(int recid){
        List<IRNombres> ixrnames;
        
        String strSQL = "";
        
        strSQL = strSQL + "SELECT j.nombrei,i.cantidad,k.nombrem FROM IngxRec i ";
        strSQL = strSQL + "INNER JOIN Ingredientes j ON i.idIngrediente = j.idIngrediente ";
        strSQL = strSQL + "INNER JOIN Medidas k ON i.idMedida = k.idMedida ";
        strSQL = strSQL + "WHERE i.idReceta = :idReceta";
                
        try {
             //ixr = em.createQuery("SELECT i FROM IngxRec i WHERE i.idReceta = :idReceta")
             ixrnames= em.createQuery(strSQL)
                    .setParameter("idReceta", recid)
                    .getResultList();
                     
             return ixrnames;

        } catch (Exception e) {
            return null;
        }
    }
    
    
    
}
