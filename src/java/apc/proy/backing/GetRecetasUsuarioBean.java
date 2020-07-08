/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.backing;

import apc.proy.entity.Colecciones;
import apc.proy.entity.Receta;
import apc.proy.entity.facades.CategoriasFacadeLocal;
import apc.proy.entity.facades.ColeccionesFacadeLocal;
import apc.proy.entity.facades.IngxRecFacadeLocal;
import apc.proy.entity.facades.RecetaFacadeLocal;
import apc.proy.entity.facades.UsuarioFacadeLocal;
import apc.proy.model.dto.IRNombres;
import apc.proy.session.SessionUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author desa
 */
@ManagedBean
@ViewScoped
public class GetRecetasUsuarioBean implements Serializable {
    
    @EJB
    private RecetaFacadeLocal recFacade;
    @EJB 
    private CategoriasFacadeLocal catFacade;
    @EJB 
    private UsuarioFacadeLocal userFacade;
    @EJB 
    private IngxRecFacadeLocal ixrFacade;
    @EJB
    private ColeccionesFacadeLocal colFacade;
    
    private List<Receta> recetasUN;
    private List<Receta> recetasCOL;
    private List<IRNombres> ingredientesRec;
    private Receta receta;
    private Receta recetadel;
    private Colecciones coleccion;
    private Integer idreceta;
    private String usern;
    private String catn;
    private String coln;
    private int nrec;
    
    public GetRecetasUsuarioBean() {
    }
    
    @PostConstruct
    public void inicializar(){
        HttpSession session = SessionUtils.getSession();
        int iduser= Integer.parseInt((String) session.getAttribute("userid"));
        receta= new Receta();
        ingredientesRec= new ArrayList<IRNombres>();
        consultarRecByUser(iduser);
    }
    
    public int getNrec() {
        return nrec;
    }

    public void setNrec(int nrec) {
        this.nrec = nrec;
    }
    
    public void consultarRecByUser(int userid){
        recetasUN= recFacade.findRecetasByUN(userid);
        nrec= recetasUN.size();
    }
    
    public String consultarRecByCol(){
        int colid= coleccion.getIdColeccion();
        recetasCOL= recFacade.findRecetasByCol(colid);
        
        return "/login/recetasColeccionesTemplate";
    }
    
    public void recetaListener(ActionEvent event){
        idreceta = (Integer)event.getComponent().getAttributes().get("recid");
    }
    
    public String consultarUserRecetaByid(){
        receta= recFacade.findRecetaByid(idreceta);
        
        int idcat= receta.getIdCategoria();
        int iduser= receta.getIdUsuario();
        int idcol= receta.getIdColeccion();
        coln= colFacade.findColeccionByid(idcol);
        catn= catFacade.findCategoriaByid(idcat);
        usern= userFacade.findUserNombreByid(iduser);
        
        ingredientesRec= ixrFacade.findIRNamesByReceta(idreceta);
        
        
        return "/login/publishedUserTemplate";
    }
    
    public String deleteReceta(){
        recFacade.remove(receta);
        
        return "/login/profileTemplate";
    }

    
    
    public List<Receta> getRecetasUN() {
        return recetasUN;
    }

    public void setRecetasUN(List<Receta> recetasUN) {
        this.recetasUN = recetasUN;
    }

    public List<Receta> getRecetasCOL() {
        return recetasCOL;
    }

    public void setRecetasCOL(List<Receta> recetasCOL) {
        this.recetasCOL = recetasCOL;
    }

    public Colecciones getColeccion() {
        return coleccion;
    }

    public void setColeccion(Colecciones coleccion) {
        this.coleccion = coleccion;
    }

    public List<IRNombres> getIngredientesRec() {
        return ingredientesRec;
    }

    public void setIngredientesRec(List<IRNombres> ingredientesRec) {
        this.ingredientesRec = ingredientesRec;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Receta getRecetadel() {
        return recetadel;
    }

    public void setRecetadel(Receta recetadel) {
        this.recetadel = recetadel;
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

    public String getColn() {
        return coln;
    }

    public void setColn(String coln) {
        this.coln = coln;
    }
    

}
