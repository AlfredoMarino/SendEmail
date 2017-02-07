/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alfredo Mariño
 */
@Entity
@Table(name = "involucrado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Involucrado.findAll", query = "SELECT i FROM Involucrado i"),
    @NamedQuery(name = "Involucrado.findByCodigoInvolucrado", query = "SELECT i FROM Involucrado i WHERE i.codigoInvolucrado = :codigoInvolucrado")})
public class Involucrado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodigoInvolucrado")
    private Integer codigoInvolucrado;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "codigoInvolucrado")
    private Bitacora bitacora;
    @JoinColumn(name = "CodigoPersona", referencedColumnName = "CodigoPersona")
    @OneToOne(optional = false)
    private Persona codigoPersona;

    public Involucrado() {
    }

    public Involucrado(Integer codigoInvolucrado) {
        this.codigoInvolucrado = codigoInvolucrado;
    }

    public Integer getCodigoInvolucrado() {
        return codigoInvolucrado;
    }

    public void setCodigoInvolucrado(Integer codigoInvolucrado) {
        this.codigoInvolucrado = codigoInvolucrado;
    }

    public Bitacora getBitacora() {
        return bitacora;
    }

    public void setBitacora(Bitacora bitacora) {
        this.bitacora = bitacora;
    }

    public Persona getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(Persona codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoInvolucrado != null ? codigoInvolucrado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Involucrado)) {
            return false;
        }
        Involucrado other = (Involucrado) object;
        if ((this.codigoInvolucrado == null && other.codigoInvolucrado != null) || (this.codigoInvolucrado != null && !this.codigoInvolucrado.equals(other.codigoInvolucrado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB.Involucrado[ codigoInvolucrado=" + codigoInvolucrado + " ]";
    }
    
}
