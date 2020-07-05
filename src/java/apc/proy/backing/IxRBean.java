/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.backing;

import apc.proy.entity.IngxRec;
import apc.proy.entity.Medidas;
import apc.proy.entity.facades.IngxRecFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author desa
 */
@ManagedBean
@SessionScoped
public class IxRBean implements Serializable {

    @ManagedProperty("#{medidasBean}")
    private MedidasBean datam;
    
    
    @EJB
    private IngxRecFacadeLocal ixrFacade;

    private List<IngxRec> ingredientes;
    private List<IngxRec> ingredientes2;

    private List<IngxRec> ingRec;

    private IngxRec ixr;
    private Medidas medida;

    public IxRBean() {
    }

    @PostConstruct
    public void inicializar() {
        consultarIngxRec();
        consultarAllIR();
        ixr = new IngxRec();
        medida= new Medidas();
        ingRec = new ArrayList<IngxRec>();
    }

    public String registrar() {
        for(IngxRec ixrL :ingRec){
            ixrL.setIdReceta(3);
            ixrFacade.create(ixrL);
        }

        return "/faces/Pruebas";
    }

    public void createNew() {
        int mid= medida.getIdMedida();
        ixr.setIdMedida(mid);
        ixr.setIdReceta(0);
        ingRec.add(ixr);
        ixr = new IngxRec();
        
    }
    
    public void clearList(){
        ingRec.clear();
    }
    
    public void consultarIngxRec() {
        ingredientes = ixrFacade.findIRByReceta(3);
    }

    
    
    public void consultarAllIR() {
        ingredientes2 = ixrFacade.findAll();
    }

    public List<Medidas> compMedidas(String query){
        String queryLowerCase = query.toLowerCase();
        List<Medidas> allMed= datam.getMedidas();
        return allMed.stream().filter(t -> t.getNombrem().toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
    }
    
    
    
    
    public IngxRec getIxr() {
        return ixr;
    }

    public void setIxr(IngxRec ixr) {
        this.ixr = ixr;
    }

    public List<IngxRec> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngxRec> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<IngxRec> getIngredientes2() {
        return ingredientes2;
    }

    public void setIngredientes2(List<IngxRec> ingredientes2) {
        this.ingredientes2 = ingredientes2;
    }

    public List<IngxRec> getIngRec() {
        return ingRec;
    }

    public void setIngRec(List<IngxRec> ingRec) {
        this.ingRec = ingRec;
    }

    public MedidasBean getDatam() {
        return datam;
    }

    public void setDatam(MedidasBean datam) {
        this.datam = datam;
    }

    public Medidas getMedida() {
        return medida;
    }

    public void setMedida(Medidas medida) {
        this.medida = medida;
    }
    
}
