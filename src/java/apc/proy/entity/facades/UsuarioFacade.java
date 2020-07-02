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
import javax.persistence.TypedQuery;

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

    @Override
    public Usuario findUsuario(String usern) {

        Usuario Nombre;

        try {
            Nombre = (Usuario) em.createQuery("SELECT u FROM Usuario u WHERE u.usern = :usern")
                    .setParameter("usern", usern)
                    .getSingleResult();

            return Nombre;

        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public Usuario findUsuarioByid(int userid){
        Usuario User;
        
        try {
            User = (Usuario) em.createQuery("SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
                    .setParameter("idUsuario", userid)
                    .getSingleResult();

            return User;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Usuario findMailRep(String correo) {

        Usuario Mail;

        try {
            Mail = (Usuario) em.createQuery("SELECT u FROM Usuario u WHERE u.correo = :correo")
                    .setParameter("correo", correo)
                    .getSingleResult();

            return Mail;

        } catch (Exception e) {
            return null;
        }
    }
    
}
