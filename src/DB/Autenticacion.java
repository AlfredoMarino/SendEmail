/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "autenticacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autenticacion.findAll", query = "SELECT a FROM Autenticacion a"),
    @NamedQuery(name = "Autenticacion.findByCodigoPersona", query = "SELECT a FROM Autenticacion a WHERE a.codigoPersona = :codigoPersona"),
    @NamedQuery(name = "Autenticacion.findByUserAutenticacion", query = "SELECT a FROM Autenticacion a WHERE a.userAutenticacion = :userAutenticacion"),
    @NamedQuery(name = "Autenticacion.findByPassAutenticacion", query = "SELECT a FROM Autenticacion a WHERE a.passAutenticacion = :passAutenticacion"),
    @NamedQuery(name = "Autenticacion.findByNivelAutenticacion", query = "SELECT a FROM Autenticacion a WHERE a.nivelAutenticacion = :nivelAutenticacion")})
public class Autenticacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CodigoPersona")
    private Integer codigoPersona;
    @Basic(optional = false)
    @Column(name = "UserAutenticacion")
    private String userAutenticacion;
    @Basic(optional = false)
    @Column(name = "PassAutenticacion")
    private String passAutenticacion;
    @Basic(optional = false)
    @Column(name = "NivelAutenticacion")
    private boolean nivelAutenticacion;
    @JoinColumn(name = "CodigoPersona", referencedColumnName = "CodigoPersona", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;

    public Autenticacion() {
    }

    public Autenticacion(Integer codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    public Autenticacion(Integer codigoPersona, String userAutenticacion, String passAutenticacion, boolean nivelAutenticacion) {
        this.codigoPersona = codigoPersona;
        this.userAutenticacion = userAutenticacion;
        this.passAutenticacion = passAutenticacion;
        this.nivelAutenticacion = nivelAutenticacion;
    }

    public Integer getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(Integer codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    public String getUserAutenticacion() {
        return userAutenticacion;
    }

    public void setUserAutenticacion(String userAutenticacion) {
        this.userAutenticacion = userAutenticacion;
    }

    public String getPassAutenticacion() {
        return passAutenticacion;
    }

    public void setPassAutenticacion(String passAutenticacion) {
        this.passAutenticacion = passAutenticacion;
    }

    public boolean getNivelAutenticacion() {
        return nivelAutenticacion;
    }

    public void setNivelAutenticacion(boolean nivelAutenticacion) {
        this.nivelAutenticacion = nivelAutenticacion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPersona != null ? codigoPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autenticacion)) {
            return false;
        }
        Autenticacion other = (Autenticacion) object;
        if ((this.codigoPersona == null && other.codigoPersona != null) || (this.codigoPersona != null && !this.codigoPersona.equals(other.codigoPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB.Autenticacion[ codigoPersona=" + codigoPersona + " ]";
    }
    
}
