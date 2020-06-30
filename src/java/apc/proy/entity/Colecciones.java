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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author desa
 */
@Entity
@Table(name = "Colecciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colecciones.findAll", query = "SELECT c FROM Colecciones c")
    , @NamedQuery(name = "Colecciones.findByIdColeccion", query = "SELECT c FROM Colecciones c WHERE c.idColeccion = :idColeccion")
    , @NamedQuery(name = "Colecciones.findByIdUsuario", query = "SELECT c FROM Colecciones c WHERE c.idUsuario = :idUsuario")
    , @NamedQuery(name = "Colecciones.findByNombrecol", query = "SELECT c FROM Colecciones c WHERE c.nombrecol = :nombrecol")
    , @NamedQuery(name = "Colecciones.findByDescripcion", query = "SELECT c FROM Colecciones c WHERE c.descripcion = :descripcion")})
public class Colecciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_coleccion")
    private Integer idColeccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombrecol")
    private String nombrecol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion")
    private String descripcion;

    public Colecciones() {
    }

    public Colecciones(Integer idColeccion) {
        this.idColeccion = idColeccion;
    }

    public Colecciones(Integer idColeccion, int idUsuario, String nombrecol, String descripcion) {
        this.idColeccion = idColeccion;
        this.idUsuario = idUsuario;
        this.nombrecol = nombrecol;
        this.descripcion = descripcion;
    }

    public Integer getIdColeccion() {
        return idColeccion;
    }

    public void setIdColeccion(Integer idColeccion) {
        this.idColeccion = idColeccion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombrecol() {
        return nombrecol;
    }

    public void setNombrecol(String nombrecol) {
        this.nombrecol = nombrecol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idColeccion != null ? idColeccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colecciones)) {
            return false;
        }
        Colecciones other = (Colecciones) object;
        if ((this.idColeccion == null && other.idColeccion != null) || (this.idColeccion != null && !this.idColeccion.equals(other.idColeccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apc.proy.entity.Colecciones[ idColeccion=" + idColeccion + " ]";
    }
    
}
