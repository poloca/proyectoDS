package apc.proy.backing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import apc.proy.model.dto.Receta;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped //se cambio en lugar de ViewScoped (temporalmente- despues cambiar)
public class SubmitBean {

    private Receta receta;
    
    public SubmitBean() {
    }
    
    @PostConstruct
    public void inicializar(){
        receta= new Receta();
    }
    
    public String publicar(){
        return "publishedTemplate";
    }
    
    public void listener(ActionEvent ev){
        System.out.println("Ejecutar listener");
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }
    
    
    
}
