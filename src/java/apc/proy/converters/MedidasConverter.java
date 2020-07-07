/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.converters;

import apc.proy.backing.MedidasBean;
import apc.proy.entity.Medidas;
import javax.el.ValueExpression;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


@FacesConverter(value="medidasConverter")
public class MedidasConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException{
        ValueExpression vex= context.getApplication().getExpressionFactory()
                .createValueExpression(context.getELContext(), "#{medidasBean}", MedidasBean.class);
        MedidasBean med= (MedidasBean) vex.getValue(context.getELContext());
        return med.getMedidasNombre(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null) {
            try{
               return ((Medidas)value).getIdMedida().toString();
            }catch(Exception e){
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Measure."));
            }
            
        }
        else {
            return null;
        }
    }
}
