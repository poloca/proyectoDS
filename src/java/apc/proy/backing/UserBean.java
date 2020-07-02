/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.backing;

import apc.proy.entity.Usuario;
import apc.proy.entity.facades.UsuarioFacadeLocal;
import apc.proy.session.SessionUtils;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author desa
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    @EJB
    private UsuarioFacadeLocal userFacade;

    HttpSession session = SessionUtils.getSession();
    private Usuario founduser;
    private String confPassword;

    public UserBean() {
    }

    @PostConstruct
    public void inicializar() {
        int iduser = Integer.parseInt((String) session.getAttribute("userid"));
        founduser = new Usuario();
        founduser = userFacade.findUsuarioByid(iduser);
    }

    public String actualizar() {
        userFacade.edit(founduser);

        return "/login/profileTemplate";
    }

    public Usuario getFounduser() {
        return founduser;
    }

    public void setFounduser(Usuario founduser) {
        this.founduser = founduser;
    }

    public String getConfPassword() {
        return confPassword;
    }

    public void setConfPassword(String confPassword) {
        this.confPassword = confPassword;
    }

    public void validatePass(FacesContext context, UIComponent component, Object value) {
        String confPassword = (String) value;
        UIInput passwordInput = (UIInput) component.findComponent("password");
        String password = (String) passwordInput.getLocalValue();

        if (password == null || confPassword == null || !password.equals(confPassword)) {

            String message = context.getApplication().evaluateExpressionGet(context, "#{lang['val.err.pass']}", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }

    public void validateUser(FacesContext context, UIComponent component, Object value) {

        String usern = (String) value;

        Usuario usr = userFacade.findUsuario(usern);
        int iduser = Integer.parseInt((String) session.getAttribute("userid"));

        if (usr != null) {
            int idu = usr.getIdUsuario();
            
            if(idu != iduser){
                String message = context.getApplication().evaluateExpressionGet(context, "#{lang['val.err.usur']}", String.class);
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
                throw new ValidatorException(msg);
            }
        }
    }

    public void validateMail(FacesContext context, UIComponent component, Object value) {

        String correo = (String) value;

        Usuario mlr = userFacade.findMailRep(correo);

        int iduser = Integer.parseInt((String) session.getAttribute("userid"));

        if (mlr != null) {
            int idu = mlr.getIdUsuario();

            if (idu != iduser) {
                String message = context.getApplication().evaluateExpressionGet(context, "#{lang['val.err.mail']}", String.class);
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
                throw new ValidatorException(msg);
            }

        }
    }

}
