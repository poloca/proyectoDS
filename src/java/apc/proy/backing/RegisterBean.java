/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.backing;

import apc.proy.entity.Usuario;
import apc.proy.entity.facades.UsuarioFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

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

   
}
