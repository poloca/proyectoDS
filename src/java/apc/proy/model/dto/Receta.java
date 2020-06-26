/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.model.dto;

import java.io.Serializable;

/**
 *
 * @author desa
 */
public class Receta implements Serializable{
    private String titulo;
    private String categoria;
    private int tprep;
    private int tcook;
    private int porcion;
    private String dificultad;
    private String ingrediente;
    private String preparacion;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getTprep() {
        return tprep;
    }

    public void setTprep(int tprep) {
        this.tprep = tprep;
    }

    public int getTcook() {
        return tcook;
    }

    public void setTcook(int tcook) {
        this.tcook = tcook;
    }

    public int getPorcion() {
        return porcion;
    }

    public void setPorcion(int porcion) {
        this.porcion = porcion;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }
    
    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }
    
    
    
}
