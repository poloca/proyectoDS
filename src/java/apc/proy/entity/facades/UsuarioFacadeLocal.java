/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.entity.facades;

import apc.proy.entity.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author desa
 */
@Local
public interface UsuarioFacadeLocal {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);
    
    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();

    public Usuario findUsuario(String usern);
    
    public Usuario findMailRep(String correo);
    
}
