/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.backing;


import apc.proy.entity.Categorias;
import apc.proy.entity.facades.CategoriasFacadeLocal;
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
public class CategoriasBean implements Serializable {

    @EJB
    private CategoriasFacadeLocal catFacade;
    
    private List<Categorias> categorias;
    
    
    public CategoriasBean() {
    }
    
    @PostConstruct
    public void inicializar(){
        consultarCategorias();
    }
    
    public void consultarCategorias(){
        categorias= catFacade.findAllCat();
    }
    
    public Categorias getCategoriasNombre(Integer id){
        if(id==null){
            throw new IllegalArgumentException("Select a valid option");
        }
        for(Categorias cat: categorias){
            if(id.equals(cat.getIdCategoria())){
                return cat;
            }
        }
        return null;
    }

    public List<Categorias> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categorias> categorias) {
        this.categorias = categorias;
    }
    
    
}
