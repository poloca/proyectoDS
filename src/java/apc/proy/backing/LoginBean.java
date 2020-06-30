/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.backing;

import apc.proy.entity.Usuario;
import apc.proy.entity.facades.UsuarioFacadeLocal;
import apc.proy.session.SessionUtils;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author desa
 */
@ManagedBean(name = "loginBack")
@SessionScoped //se cambio en lugar de ViewScoped (temporalmente- despues cambiar)
public class LoginBean implements Serializable {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    private String Usuario;
    private String Password;
    private int x;

    public String validarLogin() {
        Usuario u = usuarioFacade.findUsuario(Usuario);

        if (u != null) {
            String p = u.getPassword();
            String user= u.getUsern();
            String id= (String) u.getIdUsuario().toString();
            
            if (p.equals(Password)) {
                HttpSession session = SessionUtils.getSession();
		session.setAttribute("username", user);
                session.setAttribute("userid", id);
               
                return "profileTemplate";

            } else {

                FacesContext fctx = FacesContext.getCurrentInstance();
                FacesMessage msg = new FacesMessage("#{lang['val.log.err']}");
                fctx.addMessage(null, msg);

                return null;
            }
        }

        FacesContext fctx2 = FacesContext.getCurrentInstance();
        FacesMessage msg2 = new FacesMessage("#{lang['val.log.noex']}");
        fctx2.addMessage(null, msg2);

        return null;
    }
    
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        
        return "index";
    }

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {

    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

}
