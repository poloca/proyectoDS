/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.entity.facades;

import apc.proy.entity.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author desa
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "ProyectoAbrilPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    /**
     * Busca en la tabla si existe un usuario con el mismo nombre
     * @param usern
     * @return 
     */
    @Override
    public Usuario findUsuario(String usern){
        return (Usuario) em.createQuery("select object(u) from Usuario u " + "where u.usern = :usern")
                .setParameter("usern", usern.toUpperCase())
                .getSingleResult();
    }
    
}
