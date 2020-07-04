/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.backing;

import apc.proy.entity.Ingredientes;
import apc.proy.entity.facades.IngredientesFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author desa
 */
@ManagedBean
@SessionScoped
public class IngredientesBean implements Serializable{

    @EJB
    private IngredientesFacadeLocal ingFacade;
    
    private List<Ingredientes> ingredientes;
    /**
     * Creates a new instance of IngredientesBean
     */
    public IngredientesBean() {
    }

    @PostConstruct
    public void inicializar(){
        consultarIngredientes();
    }
    
    public void consultarIngredientes(){
        ingredientes= ingFacade.findAllIng();
    }
    
    public List<Ingredientes> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingredientes> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    
}
