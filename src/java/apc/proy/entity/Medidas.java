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
@Table(name = "Medidas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medidas.findAll", query = "SELECT m FROM Medidas m")
    , @NamedQuery(name = "Medidas.findByIdMedida", query = "SELECT m FROM Medidas m WHERE m.idMedida = :idMedida")
    , @NamedQuery(name = "Medidas.findByNombrem", query = "SELECT m FROM Medidas m WHERE m.nombrem = :nombrem")})
public class Medidas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_medida")
    private Integer idMedida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nombrem")
    private String nombrem;

    public Medidas() {
    }

    public Medidas(Integer idMedida) {
        this.idMedida = idMedida;
    }

    public Medidas(Integer idMedida, String nombrem) {
        this.idMedida = idMedida;
        this.nombrem = nombrem;
    }

    public Integer getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(Integer idMedida) {
        this.idMedida = idMedida;
    }

    public String getNombrem() {
        return nombrem;
    }

    public void setNombrem(String nombrem) {
        this.nombrem = nombrem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedida != null ? idMedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medidas)) {
            return false;
        }
        Medidas other = (Medidas) object;
        if ((this.idMedida == null && other.idMedida != null) || (this.idMedida != null && !this.idMedida.equals(other.idMedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apc.proy.entity.Medidas[ idMedida=" + idMedida + " ]";
    }
    
}
