/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alfredo Mariño
 */
@Entity
@Table(name = "tarea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarea.findAll", query = "SELECT t FROM Tarea t"),
    @NamedQuery(name = "Tarea.findByCodigoTarea", query = "SELECT t FROM Tarea t WHERE t.codigoTarea = :codigoTarea"),
    @NamedQuery(name = "Tarea.findByFechaRecepcionTarea", query = "SELECT t FROM Tarea t WHERE t.fechaRecepcionTarea = :fechaRecepcionTarea"),
    @NamedQuery(name = "Tarea.findByHoraRecepcionTarea", query = "SELECT t FROM Tarea t WHERE t.horaRecepcionTarea = :horaRecepcionTarea"),
    @NamedQuery(name = "Tarea.findByFechaEstimadaTarea", query = "SELECT t FROM Tarea t WHERE t.fechaEstimadaTarea = :fechaEstimadaTarea"),
    @NamedQuery(name = "Tarea.findByHoraEstimadaTarea", query = "SELECT t FROM Tarea t WHERE t.horaEstimadaTarea = :horaEstimadaTarea"),
    @NamedQuery(name = "Tarea.findByCarpetaEvento", query = "SELECT t FROM Tarea t WHERE t.carpetaEvento = :carpetaEvento"),
    @NamedQuery(name = "Tarea.findByFechaResolucionTarea", query = "SELECT t FROM Tarea t WHERE t.fechaResolucionTarea = :fechaResolucionTarea"),
    @NamedQuery(name = "Tarea.findByHoraResolucionTarea", query = "SELECT t FROM Tarea t WHERE t.horaResolucionTarea = :horaResolucionTarea")})
public class Tarea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodigoTarea")
    private Integer codigoTarea;
    @Basic(optional = false)
    @Lob
    @Column(name = "DescripcionTarea")
    private String descripcionTarea;
    @Basic(optional = false)
    @Column(name = "FechaRecepcionTarea")
    @Temporal(TemporalType.DATE)
    private Date fechaRecepcionTarea;
    @Basic(optional = false)
    @Column(name = "HoraRecepcionTarea")
    @Temporal(TemporalType.TIME)
    private Date horaRecepcionTarea;
    @Basic(optional = false)
    @Column(name = "FechaEstimadaTarea")
    @Temporal(TemporalType.DATE)
    private Date fechaEstimadaTarea;
    @Basic(optional = false)
    @Column(name = "HoraEstimadaTarea")
    @Temporal(TemporalType.TIME)
    private Date horaEstimadaTarea;
    @Basic(optional = false)
    @Column(name = "CarpetaEvento")
    private String carpetaEvento;
    @Basic(optional = false)
    @Lob
    @Column(name = "ObservacionEvento")
    private String observacionEvento;
    @Basic(optional = false)
    @Column(name = "FechaResolucionTarea")
    @Temporal(TemporalType.DATE)
    private Date fechaResolucionTarea;
    @Basic(optional = false)
    @Column(name = "HoraResolucionTarea")
    @Temporal(TemporalType.TIME)
    private Date horaResolucionTarea;
    @JoinColumn(name = "CodigoInstitucion", referencedColumnName = "CodigoInstitucion")
    @ManyToOne(optional = false)
    private Institucion codigoInstitucion;
    @JoinColumn(name = "TipoTarea", referencedColumnName = "TipoTarea")
    @ManyToOne(optional = false)
    private Seguimiento tipoTarea;
    @JoinColumn(name = "PrioridadSeguimiento", referencedColumnName = "TipoTarea")
    @ManyToOne(optional = false)
    private Seguimiento prioridadSeguimiento;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "codigoInstitucion")
    private Bitacora bitacora;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tipoTarea")
    private Bitacora bitacora1;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "codigoTarea")
    private Bitacora bitacora2;

    public Tarea() {
    }

    public Tarea(Integer codigoTarea) {
        this.codigoTarea = codigoTarea;
    }

    public Tarea(Integer codigoTarea, String descripcionTarea, Date fechaRecepcionTarea, Date horaRecepcionTarea, Date fechaEstimadaTarea, Date horaEstimadaTarea, String carpetaEvento, String observacionEvento, Date fechaResolucionTarea, Date horaResolucionTarea) {
        this.codigoTarea = codigoTarea;
        this.descripcionTarea = descripcionTarea;
        this.fechaRecepcionTarea = fechaRecepcionTarea;
        this.horaRecepcionTarea = horaRecepcionTarea;
        this.fechaEstimadaTarea = fechaEstimadaTarea;
        this.horaEstimadaTarea = horaEstimadaTarea;
        this.carpetaEvento = carpetaEvento;
        this.observacionEvento = observacionEvento;
        this.fechaResolucionTarea = fechaResolucionTarea;
        this.horaResolucionTarea = horaResolucionTarea;
    }

    public Integer getCodigoTarea() {
        return codigoTarea;
    }

    public void setCodigoTarea(Integer codigoTarea) {
        this.codigoTarea = codigoTarea;
    }

    public String getDescripcionTarea() {
        return descripcionTarea;
    }

    public void setDescripcionTarea(String descripcionTarea) {
        this.descripcionTarea = descripcionTarea;
    }

    public Date getFechaRecepcionTarea() {
        return fechaRecepcionTarea;
    }

    public void setFechaRecepcionTarea(Date fechaRecepcionTarea) {
        this.fechaRecepcionTarea = fechaRecepcionTarea;
    }

    public Date getHoraRecepcionTarea() {
        return horaRecepcionTarea;
    }

    public void setHoraRecepcionTarea(Date horaRecepcionTarea) {
        this.horaRecepcionTarea = horaRecepcionTarea;
    }

    public Date getFechaEstimadaTarea() {
        return fechaEstimadaTarea;
    }

    public void setFechaEstimadaTarea(Date fechaEstimadaTarea) {
        this.fechaEstimadaTarea = fechaEstimadaTarea;
    }

    public Date getHoraEstimadaTarea() {
        return horaEstimadaTarea;
    }

    public void setHoraEstimadaTarea(Date horaEstimadaTarea) {
        this.horaEstimadaTarea = horaEstimadaTarea;
    }

    public String getCarpetaEvento() {
        return carpetaEvento;
    }

    public void setCarpetaEvento(String carpetaEvento) {
        this.carpetaEvento = carpetaEvento;
    }

    public String getObservacionEvento() {
        return observacionEvento;
    }

    public void setObservacionEvento(String observacionEvento) {
        this.observacionEvento = observacionEvento;
    }

    public Date getFechaResolucionTarea() {
        return fechaResolucionTarea;
    }

    public void setFechaResolucionTarea(Date fechaResolucionTarea) {
        this.fechaResolucionTarea = fechaResolucionTarea;
    }

    public Date getHoraResolucionTarea() {
        return horaResolucionTarea;
    }

    public void setHoraResolucionTarea(Date horaResolucionTarea) {
        this.horaResolucionTarea = horaResolucionTarea;
    }

    public Institucion getCodigoInstitucion() {
        return codigoInstitucion;
    }

    public void setCodigoInstitucion(Institucion codigoInstitucion) {
        this.codigoInstitucion = codigoInstitucion;
    }

    public Seguimiento getTipoTarea() {
        return tipoTarea;
    }

    public void setTipoTarea(Seguimiento tipoTarea) {
        this.tipoTarea = tipoTarea;
    }

    public Seguimiento getPrioridadSeguimiento() {
        return prioridadSeguimiento;
    }

    public void setPrioridadSeguimiento(Seguimiento prioridadSeguimiento) {
        this.prioridadSeguimiento = prioridadSeguimiento;
    }

    public Bitacora getBitacora() {
        return bitacora;
    }

    public void setBitacora(Bitacora bitacora) {
        this.bitacora = bitacora;
    }

    public Bitacora getBitacora1() {
        return bitacora1;
    }

    public void setBitacora1(Bitacora bitacora1) {
        this.bitacora1 = bitacora1;
    }

    public Bitacora getBitacora2() {
        return bitacora2;
    }

    public void setBitacora2(Bitacora bitacora2) {
        this.bitacora2 = bitacora2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTarea != null ? codigoTarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarea)) {
            return false;
        }
        Tarea other = (Tarea) object;
        if ((this.codigoTarea == null && other.codigoTarea != null) || (this.codigoTarea != null && !this.codigoTarea.equals(other.codigoTarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB.Tarea[ codigoTarea=" + codigoTarea + " ]";
    }
    
}
