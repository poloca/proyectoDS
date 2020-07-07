/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.converters;

import apc.proy.backing.CategoriasBean;
import apc.proy.entity.Categorias;
import javax.el.ValueExpression;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


@FacesConverter(value="categoriasConverter")
public class CategoriasConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException{
        ValueExpression vex= context.getApplication().getExpressionFactory()
                .createValueExpression(context.getELContext(), "#{categoriasBean}", CategoriasBean.class);
        CategoriasBean cat= (CategoriasBean) vex.getValue(context.getELContext());
        return cat.getCategoriasNombre(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null) {
            try{
               return ((Categorias)value).getIdCategoria().toString();
            }catch(Exception e){
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Category."));
            }
            
        }
        else {
            return null;
        }
    }
}
