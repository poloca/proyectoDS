/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.backing;

import apc.proy.entity.Usuario;
import apc.proy.entity.facades.UsuarioFacadeLocal;
import apc.proy.session.SessionUtils;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped //se cambio en lugar de ViewScoped (temporalmente- despues cambiar)
public class RegisterBean {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    private String confPassword;
    private Usuario usuario;
    
    public RegisterBean() {
    }

    @PostConstruct
    public void inicializar() {
        usuario = new Usuario();
    }

    public String registrar() {
        usuarioFacade.create(usuario);
        
        String user= usuario.getUsern();
        String id= (String) usuario.getIdUsuario().toString();
    
        HttpSession session = SessionUtils.getSession();
		session.setAttribute("username", user);
                session.setAttribute("userid", id);
                
        return "profileTemplate";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        
        Usuario usr = usuarioFacade.findUsuario(usern);
        
        if (usr != null) {
            String message = context.getApplication().evaluateExpressionGet(context, "#{lang['val.err.usur']}", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }
    
    public void validateMail(FacesContext context, UIComponent component, Object value) {

        String correo = (String) value;
        
        Usuario mlr = usuarioFacade.findMailRep(correo);
        
        if (mlr != null) {
            String message = context.getApplication().evaluateExpressionGet(context, "#{lang['val.err.mail']}", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }
  
    
    
}
