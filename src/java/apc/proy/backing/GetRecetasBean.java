/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.backing;

import apc.proy.entity.IngxRec;
import apc.proy.entity.Receta;
import apc.proy.entity.facades.CategoriasFacadeLocal;
import apc.proy.entity.facades.IngxRecFacadeLocal;
import apc.proy.entity.facades.RecetaFacadeLocal;
import apc.proy.entity.facades.UsuarioFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author desa
 */
@ManagedBean
@SessionScoped
public class GetRecetasBean implements Serializable {

    @EJB 
    private RecetaFacadeLocal recFacade;
    @EJB 
    private CategoriasFacadeLocal catFacade;
    @EJB 
    private UsuarioFacadeLocal userFacade;
    @EJB 
    private IngxRecFacadeLocal ixrFacade;
    
    private List<Receta> recetas;
    private List<IngxRec> ingredientesRec;
    private Receta receta;
    private Integer idreceta;
    private String usern;
    private String catn;
    
    
    public GetRecetasBean() {
    }
    
    @PostConstruct
    public void inicializar(){
        receta= new Receta();
        consultarAllRecetas();
    }
    
    public void recetaListener(ActionEvent event){

	idreceta = (Integer)event.getComponent().getAttributes().get("recid");

    }
    
    public void consultarAllRecetas(){
        recetas= recFacade.findAll();
    }
    
    public String consultarRecetaByid(){
        receta= recFacade.findRecetaByid(idreceta);
        
        int idcat= receta.getIdCategoria();
        int iduser= receta.getIdUsuario();
        catn= catFacade.findCategoriaByid(idcat);
        usern= userFacade.findUserNombreByid(iduser);
        
        ingredientesRec= ixrFacade.findIRByReceta(idreceta);
        
        return "/faces/publishedTemplate";
    }
    
    public List<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Integer getIdreceta() {
        return idreceta;
    }

    public void setIdreceta(Integer idreceta) {
        this.idreceta = idreceta;
    }

    public String getUsern() {
        return usern;
    }

    public void setUsern(String usern) {
        this.usern = usern;
    }

    public String getCatn() {
        return catn;
    }

    public void setCatn(String catn) {
        this.catn = catn;
    }

    public List<IngxRec> getIngredientesRec() {
        return ingredientesRec;
    }

    public void setIngredientesRec(List<IngxRec> ingredientesRec) {
        this.ingredientesRec = ingredientesRec;
    }
    
    
}
