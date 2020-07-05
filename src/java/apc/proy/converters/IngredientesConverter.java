/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.converters;

import apc.proy.backing.IngredientesBean;
import apc.proy.entity.Ingredientes;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "ingredientesConverter")
public class IngredientesConverter implements Converter {

    @ManagedProperty("#{ingredientesBean}")
    private IngredientesBean datai;

    public IngredientesBean getDatai() {
        return datai;
    }

    public void setDatai(IngredientesBean datai) {
        this.datai = datai;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                return datai.getIngredientes().get(Integer.parseInt(value));
            } catch (NumberFormatException e) {

                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Ingredient."));
            }
        }else{
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null) {
            try{
               return String.valueOf(((Ingredientes) value).getIdIngrediente()); 
            }catch(Exception e){
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Ingredient."));
            }
            
        }
        else {
            return null;
        }
    }

}
