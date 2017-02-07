/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alfredo Mariño
 */
@Entity
@Table(name = "seguimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguimiento.findAll", query = "SELECT s FROM Seguimiento s"),
    @NamedQuery(name = "Seguimiento.findByTipoTarea", query = "SELECT s FROM Seguimiento s WHERE s.tipoTarea = :tipoTarea"),
    @NamedQuery(name = "Seguimiento.findByPrioridadSeguimiento", query = "SELECT s FROM Seguimiento s WHERE s.prioridadSeguimiento = :prioridadSeguimiento"),
    @NamedQuery(name = "Seguimiento.findByDescripcionSeguimiento", query = "SELECT s FROM Seguimiento s WHERE s.descripcionSeguimiento = :descripcionSeguimiento"),
    @NamedQuery(name = "Seguimiento.findByDiasSeguimiento", query = "SELECT s FROM Seguimiento s WHERE s.diasSeguimiento = :diasSeguimiento"),
    @NamedQuery(name = "Seguimiento.findByHorasSeguimiento", query = "SELECT s FROM Seguimiento s WHERE s.horasSeguimiento = :horasSeguimiento"),
    @NamedQuery(name = "Seguimiento.findByMaximoSeguimiento", query = "SELECT s FROM Seguimiento s WHERE s.maximoSeguimiento = :maximoSeguimiento")})
public class Seguimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TipoTarea")
    private Boolean tipoTarea;
    @Basic(optional = false)
    @Column(name = "PrioridadSeguimiento")
    private boolean prioridadSeguimiento;
    @Basic(optional = false)
    @Column(name = "DescripcionSeguimiento")
    private String descripcionSeguimiento;
    @Basic(optional = false)
    @Column(name = "DiasSeguimiento")
    private int diasSeguimiento;
    @Basic(optional = false)
    @Column(name = "HorasSeguimiento")
    private int horasSeguimiento;
    @Basic(optional = false)
    @Column(name = "MaximoSeguimiento")
    private int maximoSeguimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoTarea")
    private Collection<Tarea> tareaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prioridadSeguimiento")
    private Collection<Tarea> tareaCollection1;

    public Seguimiento() {
    }

    public Seguimiento(Boolean tipoTarea) {
        this.tipoTarea = tipoTarea;
    }

    public Seguimiento(Boolean tipoTarea, boolean prioridadSeguimiento, String descripcionSeguimiento, int diasSeguimiento, int horasSeguimiento, int maximoSeguimiento) {
        this.tipoTarea = tipoTarea;
        this.prioridadSeguimiento = prioridadSeguimiento;
        this.descripcionSeguimiento = descripcionSeguimiento;
        this.diasSeguimiento = diasSeguimiento;
        this.horasSeguimiento = horasSeguimiento;
        this.maximoSeguimiento = maximoSeguimiento;
    }

    public Boolean getTipoTarea() {
        return tipoTarea;
    }

    public void setTipoTarea(Boolean tipoTarea) {
        this.tipoTarea = tipoTarea;
    }

    public boolean getPrioridadSeguimiento() {
        return prioridadSeguimiento;
    }

    public void setPrioridadSeguimiento(boolean prioridadSeguimiento) {
        this.prioridadSeguimiento = prioridadSeguimiento;
    }

    public String getDescripcionSeguimiento() {
        return descripcionSeguimiento;
    }

    public void setDescripcionSeguimiento(String descripcionSeguimiento) {
        this.descripcionSeguimiento = descripcionSeguimiento;
    }

    public int getDiasSeguimiento() {
        return diasSeguimiento;
    }

    public void setDiasSeguimiento(int diasSeguimiento) {
        this.diasSeguimiento = diasSeguimiento;
    }

    public int getHorasSeguimiento() {
        return horasSeguimiento;
    }

    public void setHorasSeguimiento(int horasSeguimiento) {
        this.horasSeguimiento = horasSeguimiento;
    }

    public int getMaximoSeguimiento() {
        return maximoSeguimiento;
    }

    public void setMaximoSeguimiento(int maximoSeguimiento) {
        this.maximoSeguimiento = maximoSeguimiento;
    }

    @XmlTransient
    public Collection<Tarea> getTareaCollection() {
        return tareaCollection;
    }

    public void setTareaCollection(Collection<Tarea> tareaCollection) {
        this.tareaCollection = tareaCollection;
    }

    @XmlTransient
    public Collection<Tarea> getTareaCollection1() {
        return tareaCollection1;
    }

    public void setTareaCollection1(Collection<Tarea> tareaCollection1) {
        this.tareaCollection1 = tareaCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoTarea != null ? tipoTarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguimiento)) {
            return false;
        }
        Seguimiento other = (Seguimiento) object;
        if ((this.tipoTarea == null && other.tipoTarea != null) || (this.tipoTarea != null && !this.tipoTarea.equals(other.tipoTarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB.Seguimiento[ tipoTarea=" + tipoTarea + " ]";
    }
    
}
