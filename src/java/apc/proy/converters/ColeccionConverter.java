/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.converters;

import apc.proy.backing.TableCollectionBean;
import apc.proy.entity.Colecciones;
import javax.el.ValueExpression;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


@FacesConverter(value="coleccionConverter")
public class ColeccionConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException{
        ValueExpression vex= context.getApplication().getExpressionFactory()
                .createValueExpression(context.getELContext(), "#{tableCollectionBean}", TableCollectionBean.class);
        TableCollectionBean col= (TableCollectionBean) vex.getValue(context.getELContext());
        return col.getColeccionesNombre(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null) {
            try{
               return ((Colecciones)value).getIdColeccion().toString();
            }catch(Exception e){
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Collection."));
            }
            
        }
        else {
            return null;
        }
    }
}
