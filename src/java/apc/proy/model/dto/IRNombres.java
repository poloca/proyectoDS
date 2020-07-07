/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.model.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author desa
 */
public class IRNombres implements Serializable{
    private String nombrei;
    private String cantidad;
    private String nombrem;
    
    
    public IRNombres(){
    }
    
    public IRNombres(String nombrei, String cantidad, String nombrem){
        this.nombrei= nombrei;
        this.cantidad= cantidad;
        this.nombrem= nombrem;
    }
    
    public String getNombrei() {
        return nombrei;
    }

    public void setNombrei(String nombrei) {
        this.nombrei = nombrei;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombrem() {
        return nombrem;
    }

    public void setNombrem(String nombrem) {
        this.nombrem = nombrem;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.nombrei);
        hash = 89 * hash + Objects.hashCode(this.cantidad);
        hash = 89 * hash + Objects.hashCode(this.nombrem);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IRNombres other = (IRNombres) obj;
        if (!Objects.equals(this.nombrei, other.nombrei)) {
            return false;
        }
        if (!Objects.equals(this.cantidad, other.cantidad)) {
            return false;
        }
        if (!Objects.equals(this.nombrem, other.nombrem)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "IRNombres{" + "nombrei=" + nombrei + ", cantidad=" + cantidad + ", nombrem=" + nombrem + '}';
    }
    
}
