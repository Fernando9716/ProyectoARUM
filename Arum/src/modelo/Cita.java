/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fernando
 */
@Entity
@Table(name = "CITA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c"),
    @NamedQuery(name = "Cita.findByFolioCita", query = "SELECT c FROM Cita c WHERE c.folioCita = :folioCita"),
    @NamedQuery(name = "Cita.findByFecha", query = "SELECT c FROM Cita c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Cita.findByNombreCliente", query = "SELECT c FROM Cita c WHERE c.nombreCliente = :nombreCliente"),
    @NamedQuery(name = "Cita.findByServicio", query = "SELECT c FROM Cita c WHERE c.servicio = :servicio"),
    @NamedQuery(name = "Cita.findByHora", query = "SELECT c FROM Cita c WHERE c.hora = :hora")})
public class Cita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FOLIO_CITA")
    private Integer folioCita;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "NOMBRE_CLIENTE")
    private String nombreCliente;
    @Column(name = "SERVICIO")
    private String servicio;
    @Column(name = "HORA")
    private String hora;

    public Cita() {
    }

    public Cita(Integer folioCita) {
        this.folioCita = folioCita;
    }

    public Integer getFolioCita() {
        return folioCita;
    }

    public void setFolioCita(Integer folioCita) {
        this.folioCita = folioCita;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (folioCita != null ? folioCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.folioCita == null && other.folioCita != null) || (this.folioCita != null && !this.folioCita.equals(other.folioCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Cita[ folioCita=" + folioCita + " ]";
    }
    
}
