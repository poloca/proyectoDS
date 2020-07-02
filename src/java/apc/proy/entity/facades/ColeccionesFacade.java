/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.entity.facades;

import apc.proy.entity.Colecciones;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author desa
 */
@Stateless
public class ColeccionesFacade extends AbstractFacade<Colecciones> implements ColeccionesFacadeLocal {

    @PersistenceContext(unitName = "ProyectoAbrilPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ColeccionesFacade() {
        super(Colecciones.class);
    }

    @Override
    public List<Colecciones> findByUN(int iduser) {
        List<Colecciones> coleccionid;

        try {
            coleccionid = em.createQuery("SELECT c FROM Colecciones c WHERE c.idUsuario = :idUsuario")
                    .setParameter("idUsuario", iduser).getResultList();

            return coleccionid;
            
        } catch (Exception e) {
            
            return null;
        }
    }

}
