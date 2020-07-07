/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author desa
 */
@Entity
@Table(name = "Receta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receta.findAll", query = "SELECT r FROM Receta r")
    , @NamedQuery(name = "Receta.findByIdReceta", query = "SELECT r FROM Receta r WHERE r.idReceta = :idReceta")
    , @NamedQuery(name = "Receta.findByIdUsuario", query = "SELECT r FROM Receta r WHERE r.idUsuario = :idUsuario")
    , @NamedQuery(name = "Receta.findByIdCategoria", query = "SELECT r FROM Receta r WHERE r.idCategoria = :idCategoria")
    , @NamedQuery(name = "Receta.findByNombrer", query = "SELECT r FROM Receta r WHERE r.nombrer = :nombrer")
    , @NamedQuery(name = "Receta.findByTprep", query = "SELECT r FROM Receta r WHERE r.tprep = :tprep")
    , @NamedQuery(name = "Receta.findByTcook", query = "SELECT r FROM Receta r WHERE r.tcook = :tcook")
    , @NamedQuery(name = "Receta.findByPorcion", query = "SELECT r FROM Receta r WHERE r.porcion = :porcion")
    , @NamedQuery(name = "Receta.findByDificultad", query = "SELECT r FROM Receta r WHERE r.dificultad = :dificultad")
    , @NamedQuery(name = "Receta.findByPreparacion", query = "SELECT r FROM Receta r WHERE r.preparacion = :preparacion")})
public class Receta implements Serializable {

    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_receta")
    private Integer idReceta;
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "id_categoria")
    private Integer idCategoria;
    @Column(name = "id_coleccion")
    private Integer idColeccion;
    @Size(max = 100)
    @Column(name = "nombrer")
    private String nombrer;
    @Column(name = "tprep")
    private Integer tprep;
    @Column(name = "tcook")
    private Integer tcook;
    @Column(name = "porcion")
    private Integer porcion;
    @Size(max = 1)
    @Column(name = "dificultad")
    private String dificultad;
    @Size(max = 255)
    @Column(name = "preparacion")
    private String preparacion;

    public Receta() {
    }

    public Receta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public Integer getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    public Integer getIdColeccion() {
        return idColeccion;
    }

    public void setIdColeccion(Integer idColeccion) {
        this.idColeccion = idColeccion;
    }

    public String getNombrer() {
        return nombrer;
    }

    public void setNombrer(String nombrer) {
        this.nombrer = nombrer;
    }

    public Integer getTprep() {
        return tprep;
    }

    public void setTprep(Integer tprep) {
        this.tprep = tprep;
    }

    public Integer getTcook() {
        return tcook;
    }

    public void setTcook(Integer tcook) {
        this.tcook = tcook;
    }

    public Integer getPorcion() {
        return porcion;
    }

    public void setPorcion(Integer porcion) {
        this.porcion = porcion;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReceta != null ? idReceta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receta)) {
            return false;
        }
        Receta other = (Receta) object;
        if ((this.idReceta == null && other.idReceta != null) || (this.idReceta != null && !this.idReceta.equals(other.idReceta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apc.proy.entity.Receta[ idReceta=" + idReceta + " ]";
    }
}
