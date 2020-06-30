/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.backing;

import apc.proy.entity.Colecciones;
import apc.proy.entity.facades.ColeccionesFacadeLocal;
import apc.proy.session.SessionUtils;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;

/**
 *
 * @author desa
 */
@ManagedBean(name = "collectionBean")
@SessionScoped
public class CollectionBean implements Serializable {
    
    @EJB
    private ColeccionesFacadeLocal colFacade;
    
    private Colecciones coleccion;
    HttpSession session = SessionUtils.getSession();
    private int idusuario;
    
    
    
    public CollectionBean() {
        this.idusuario = Integer.parseInt((String) session.getAttribute("userid"));
    }
    
    @PostConstruct
    public void inicializar() {
        coleccion = new Colecciones();
        coleccion.setIdUsuario(idusuario);
    }
    
    public String registrar() {
        colFacade.create(coleccion);
        
        return "profileTemplate";
    }

    public Colecciones getColeccion() {
        return coleccion;
    }

    public void setColeccion(Colecciones coleccion) {
        this.coleccion = coleccion;
    }

    public int getIdusuario() {
        return idusuario;
    }
    
    
    
}
