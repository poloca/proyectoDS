/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.backing;

import apc.proy.entity.Medidas;
import apc.proy.entity.facades.MedidasFacadeLocal;
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
public class MedidasBean {

    @EJB
    private MedidasFacadeLocal medfacade;
    
    private List<Medidas> medidas;
    
    public MedidasBean() {
    }

    @PostConstruct
    public void inicializar(){
        consultarMedidas();
    }
    
    public void consultarMedidas(){
        medidas=medfacade.findAllMed();
    }
    
    public Medidas getMedidasNombre(Integer id){
        if(id==null){
            throw new IllegalArgumentException("Select a valid option");
        }
        for(Medidas med: medidas){
            if(id.equals(med.getIdMedida())){
                return med;
            }
        }
        return null;
    }
    
    public List<Medidas> getMedidas() {
        return medidas;
    }

    public void setMedidas(List<Medidas> medidas) {
        this.medidas = medidas;
    }
    
    
}
