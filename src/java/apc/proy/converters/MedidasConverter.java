/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.converters;

import apc.proy.backing.MedidasBean;
import apc.proy.entity.Medidas;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


@FacesConverter(value="medidasConverter")
public class MedidasConverter implements Converter{
    
    @ManagedProperty("#{medidasBean}")
    private MedidasBean datam;

    public MedidasBean getDatam() {
        return datam;
    }

    public void setDatam(MedidasBean datam) {
        this.datam = datam;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                return datam.getMedidas().get(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Measure."));
            }
        }
        else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null) {
            try{
               return String.valueOf(((Medidas) value).getIdMedida()); 
            }catch(Exception e){
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Measure."));
            }
            
        }
        else {
            return null;
        }
    }
    
    
    
}
