/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.backing;

import apc.proy.entity.Ingredientes;
import apc.proy.entity.Medidas;
import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author desa
 */
@ManagedBean
@SessionScoped
public class IngredientesTBean implements Serializable {

    @ManagedProperty("#{medidasBean}")
    private MedidasBean datam;
    @ManagedProperty("#{ingredientesBean}")
    private IngredientesBean datai;
    
    private Medidas medida;
    private Ingredientes ingrediente;

    public IngredientesTBean() {
    }
    
    @PostConstruct
    public void icializar(){
        medida= new Medidas();
        ingrediente= new Ingredientes();
        
    }
    
    
    public List<Medidas> compMedidas(String query){
        String queryLowerCase = query.toLowerCase();
        List<Medidas> allMed= datam.getMedidas();
        return allMed.stream().filter(t -> t.getNombrem().toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
    }
    
    public List<Ingredientes> compIngredientes(String query){
        String queryLowerCase = query.toLowerCase();
        List<Ingredientes> allIng= datai.getIngredientes();
        return allIng.stream().filter(t -> t.getNombrei().toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
    }
    

    public Medidas getMedida() {
        return medida;
    }

    public void setMedida(Medidas medida) {
        this.medida = medida;
    }

    public void setDatam(MedidasBean datam) {
        this.datam = datam;
    }
    
    public MedidasBean getDatam() {
        return datam;
    }

    public IngredientesBean getDatai() {
        return datai;
    }

    public void setDatai(IngredientesBean datai) {
        this.datai = datai;
    }

    public Ingredientes getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingredientes ingrediente) {
        this.ingrediente = ingrediente;
    }
    
    
}
