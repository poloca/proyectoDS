/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.disenio.backing;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;



/**
 *
 * @author desa
 */
@ManagedBean(name = "loginBack")
@SessionScoped //se cambio en lugar de ViewScoped (temporalmente- despues cambiar)
public class LoginBean implements Serializable{
    private String Usuario;
    private String Password;
    
    private static final String MAIL_DUMMY= "a";
    private static final String PWD_DUMMY= "a";
    
    
    public String validarLogin(){
        if(Usuario.equals(MAIL_DUMMY) && Password.equals(PWD_DUMMY)){
            return "profileTemplate";
        }
        FacesContext fctx= FacesContext.getCurrentInstance();
        FacesMessage msg= new FacesMessage("Datos de acceso incorrecto");
        
        fctx.addMessage(null, msg);
        return null;
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
