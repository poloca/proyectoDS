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
@Table(name = "IngxRec")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngxRec.findAll", query = "SELECT i FROM IngxRec i")
    , @NamedQuery(name = "IngxRec.findByIdIxr", query = "SELECT i FROM IngxRec i WHERE i.idIxr = :idIxr")
    , @NamedQuery(name = "IngxRec.findByIdReceta", query = "SELECT i FROM IngxRec i WHERE i.idReceta = :idReceta")
    , @NamedQuery(name = "IngxRec.findByIdIngrediente", query = "SELECT i FROM IngxRec i WHERE i.idIngrediente = :idIngrediente")
    , @NamedQuery(name = "IngxRec.findByCantidad", query = "SELECT i FROM IngxRec i WHERE i.cantidad = :cantidad")
    , @NamedQuery(name = "IngxRec.findByIdMedida", query = "SELECT i FROM IngxRec i WHERE i.idMedida = :idMedida")})
public class IngxRec implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ixr")
    private Integer idIxr;
    @Column(name = "id_receta")
    private Integer idReceta;
    @Column(name = "id_ingrediente")
    private Integer idIngrediente;
    @Size(max = 10)
    @Column(name = "cantidad")
    private String cantidad;
    @Column(name = "id_medida")
    private Integer idMedida;

    public IngxRec() {
    }

    public IngxRec(Integer idIxr) {
        this.idIxr = idIxr;
    }

    public Integer getIdIxr() {
        return idIxr;
    }

    public void setIdIxr(Integer idIxr) {
        this.idIxr = idIxr;
    }

    public Integer getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public Integer getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(Integer idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(Integer idMedida) {
        this.idMedida = idMedida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIxr != null ? idIxr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngxRec)) {
            return false;
        }
        IngxRec other = (IngxRec) object;
        if ((this.idIxr == null && other.idIxr != null) || (this.idIxr != null && !this.idIxr.equals(other.idIxr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apc.proy.entity.IngxRec[ idIxr=" + idIxr + " ]";
    }
    
}
