/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.backing;

import apc.proy.entity.IngxRec;
import apc.proy.entity.facades.IngxRecFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author desa
 */
@ManagedBean
@SessionScoped
public class IxRBean implements Serializable {

    @EJB
    private IngxRecFacadeLocal ixrFacade;
    
    List<IngxRec> ingredientes;
    List<IngxRec> ingredientes2;
    
    public IxRBean() {
    }
    
    public void consultarIngxRec(){
        ingredientes= ixrFacade.findIRByReceta(1);
    }
    
    public void consultarAllIR(){
       ingredientes2= ixrFacade.findAll();
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
    
    
}
