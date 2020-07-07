/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.backing;

import apc.proy.entity.Ingredientes;
import apc.proy.entity.IngxRec;
import apc.proy.entity.facades.IngredientesFacadeLocal;
import apc.proy.entity.facades.IngxRecFacadeLocal;
import apc.proy.model.dto.IRNombres;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author desa
 */
@ManagedBean
@SessionScoped
public class IxRBean implements Serializable {

    @EJB
    private IngxRecFacadeLocal ixrFacade;
    @EJB
    private IngredientesFacadeLocal ingFacade;

    private List<Ingredientes> ingredientes;
    private Ingredientes ingrediente;

    private List<IngxRec> ingRec;
    private List<IRNombres> ingRecnom;

    private IngxRec ixr;
    private IRNombres ixrnom;
    private String extra;

    public IxRBean() {
    }

    @PostConstruct
    public void inicializar() {
        ixr = new IngxRec();
        ixrnom= new IRNombres();
        ingrediente= new Ingredientes();
        ingRec = new ArrayList<IngxRec>();
        ingRecnom= new ArrayList<IRNombres>();
    }

    public String registrar() {
        String n= extra;
        for(IngxRec ixrL :ingRec){
            ixrL.setIdReceta(3);
            ixrFacade.create(ixrL);
        }

        return "/faces/Pruebas";
    }

    public void createNew() {
        int ingid= ingrediente.getIdIngrediente();
        String ingnom= ingrediente.getNombrei();
        String cant= ixr.getCantidad();
        String med= ixr.getIdMedida().toString();
        ixrnom.setNombrei(ingnom);
        ixrnom.setCantidad(cant);
        ixrnom.setNombrem(med);
        ixr.setIdIngrediente(ingid);
        ixr.setIdReceta(0);
        ingRec.add(ixr);
        ingRecnom.add(ixrnom);
        ixr = new IngxRec();
        ixrnom= new IRNombres();
        
    }
    
    public void clearList(){
        ingRec.clear();
        ingRecnom.clear();
    }
    

    
    
    public IngxRec getIxr() {
        return ixr;
    }

    public void setIxr(IngxRec ixr) {
        this.ixr = ixr;
    }

    public List<IngxRec> getIngRec() {
        return ingRec;
    }

    public void setIngRec(List<IngxRec> ingRec) {
        this.ingRec = ingRec;
    }

    public List<Ingredientes> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingredientes> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Ingredientes getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingredientes ingrediente) {
        this.ingrediente = ingrediente;
    }

    public List<IRNombres> getIngRecnom() {
        return ingRecnom;
    }

    public void setIngRecnom(List<IRNombres> ingRecnom) {
        this.ingRecnom = ingRecnom;
    }

    public IRNombres getIxrnom() {
        return ixrnom;
    }

    public void setIxrnom(IRNombres ixrnom) {
        this.ixrnom = ixrnom;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
    
    
    
}
