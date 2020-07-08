package apc.proy.backing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import apc.proy.entity.Categorias;
import apc.proy.entity.Colecciones;
import apc.proy.entity.Ingredientes;
import apc.proy.entity.IngxRec;
import apc.proy.entity.Medidas;
import apc.proy.entity.Receta;
import apc.proy.entity.facades.CategoriasFacadeLocal;
import apc.proy.entity.facades.IngredientesFacadeLocal;
import apc.proy.entity.facades.IngxRecFacadeLocal;
import apc.proy.entity.facades.MedidasFacadeLocal;
import apc.proy.entity.facades.RecetaFacadeLocal;
import apc.proy.model.dto.IRNombres;
import apc.proy.session.SessionUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped //se cambio en lugar de ViewScoped (temporalmente- despues cambiar)
public class RecetasBean implements Serializable{

    @EJB
    private RecetaFacadeLocal recFacade;
    @EJB
    private IngxRecFacadeLocal ixrFacade;
    @EJB
    private IngredientesFacadeLocal ingFacade;
    
    private List<IngxRec> ingRec;
    private List<IRNombres> ingRecnom;
    
    private Receta receta;
    private IngxRec ixr;
    private IRNombres ixrnom;
    private Medidas medida;
    private Categorias categoria;
    private Colecciones coleccion;
    
    private String ingr;
    private String cant;
    
    HttpSession session = SessionUtils.getSession();
    private int idusuario;

    public RecetasBean() {
        this.idusuario= Integer.parseInt((String) session.getAttribute("userid"));
    }
    
    @PostConstruct
    public void inicializar(){
        receta= new Receta();
        receta.setIdUsuario(idusuario);
        
        ixr= new IngxRec();
        ixrnom= new IRNombres();
        medida= new Medidas();
        categoria= new Categorias();
        coleccion= new Colecciones();
        
        ingRec = new ArrayList<IngxRec>();
        ingRecnom= new ArrayList<IRNombres>();
    }
    
    public String createReceta(){
        if(coleccion == null){
            receta.setIdColeccion(0);
        }else{
            receta.setIdColeccion(coleccion.getIdColeccion());
        }
        receta.setIdCategoria(categoria.getIdCategoria());
        recFacade.create(receta);
        int rid= receta.getIdReceta();
        for(IngxRec ixrL :ingRec){
            ixrL.setIdReceta(rid);
            ixrFacade.create(ixrL);
        }
        
        return "/login/profileTemplate";
    }
    
    public void createIRLista(){
        String ing =ingr.toLowerCase();
        Ingredientes i= ingFacade.findIngredienteNombre(ing);
        if(i == null){
           Ingredientes in= new Ingredientes();
            in.setNombrei(ing);
            ingFacade.create(in);
            ixr.setIdIngrediente(in.getIdIngrediente());
            ixrnom.setNombrei(in.getNombrei());
        }else{
            ixr.setIdIngrediente(i.getIdIngrediente());
            ixrnom.setNombrei(i.getNombrei());
        }
        
        ixr.setCantidad(cant);
        ixr.setIdMedida(medida.getIdMedida());
        ixrnom.setCantidad(cant);
        ixrnom.setNombrem(medida.getNombrem());
        ingRec.add(ixr);
        ingRecnom.add(ixrnom);
        ixr = new IngxRec();
        ixrnom= new IRNombres();
    }
    
    public void clearListaIR(){
        ingRec.clear();
        ingRecnom.clear();
    }
    
    public List<IngxRec> getIngRec() {
        return ingRec;
    }

    public void setIngRec(List<IngxRec> ingRec) {
        this.ingRec = ingRec;
    }

    public List<IRNombres> getIngRecnom() {
        return ingRecnom;
    }

    public void setIngRecnom(List<IRNombres> ingRecnom) {
        this.ingRecnom = ingRecnom;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public IngxRec getIxr() {
        return ixr;
    }

    public void setIxr(IngxRec ixr) {
        this.ixr = ixr;
    }

    public IRNombres getIxrnom() {
        return ixrnom;
    }

    public void setIxrnom(IRNombres ixrnom) {
        this.ixrnom = ixrnom;
    }

    public Medidas getMedida() {
        return medida;
    }

    public void setMedida(Medidas medida) {
        this.medida = medida;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public String getIngr() {
        return ingr;
    }

    public void setIngr(String ingr) {
        this.ingr = ingr;
    }
    
    public String getCant() {
        return cant;
    }

    public void setCant(String cant) {
        this.cant = cant;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public Colecciones getColeccion() {
        return coleccion;
    }

    public void setColeccion(Colecciones coleccion) {
        this.coleccion = coleccion;
    }
    
}
