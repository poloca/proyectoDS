/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.backing;

import apc.proy.entity.Colecciones;
import apc.proy.entity.facades.ColeccionesFacadeLocal;
import apc.proy.session.SessionUtils;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author desa
 */
@ManagedBean
@ViewScoped
public class TableCollectionBean implements Serializable{

    @EJB
    private ColeccionesFacadeLocal colFacade;
    
    private List<Colecciones> colecciones;
    private Colecciones coleccion;
    private int ncol;
    
    
    public TableCollectionBean() {
    }

    @PostConstruct
    public void inicializar() {
        HttpSession session = SessionUtils.getSession();
        int iduser= Integer.parseInt((String) session.getAttribute("userid"));
        consultarColecciones(iduser);
    }

    public int getNcol() {
        return ncol;
    }

    public void setNcol(int ncol) {
        this.ncol = ncol;
    }
    
    public void consultarColecciones(int iduser){
        colecciones= colFacade.findByUN(iduser);
        ncol= colecciones.size();
    }
    
    public Colecciones getColeccionesNombre(Integer id){
        if(id==null){
            throw new IllegalArgumentException("Select a valid option");
        }
        for(Colecciones col: colecciones){
            if(id.equals(col.getIdColeccion())){
                return col;
            }
        }
        return null;
    }
    
    public void deleteCol() {
        colFacade.remove(coleccion);
        colecciones.remove(coleccion);
        coleccion= null;
    }
    
    
    public List<Colecciones> getColecciones() {
        return colecciones;
    }
    
    public void setColecciones(List<Colecciones> colecciones) {
        this.colecciones = colecciones;
    }

    public Colecciones getColeccion() {
        return coleccion;
    }

    public void setColeccion(Colecciones coleccion) {
        this.coleccion = coleccion;
    }
    
    
}
