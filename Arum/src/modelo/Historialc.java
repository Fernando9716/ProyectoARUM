/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fernando
 */
@Entity
@Table(name = "HISTORIALC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historialc.findAll", query = "SELECT h FROM Historialc h"),
    @NamedQuery(name = "Historialc.findByFolioCita", query = "SELECT h FROM Historialc h WHERE h.folioCita = :folioCita"),
    @NamedQuery(name = "Historialc.findByNombre", query = "SELECT h FROM Historialc h WHERE h.nombre = :nombre"),
    @NamedQuery(name = "Historialc.findByServicio", query = "SELECT h FROM Historialc h WHERE h.servicio = :servicio"),
    @NamedQuery(name = "Historialc.findByFecha", query = "SELECT h FROM Historialc h WHERE h.fecha = :fecha"),
    @NamedQuery(name = "Historialc.findByHora", query = "SELECT h FROM Historialc h WHERE h.hora = :hora")})
public class Historialc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FOLIO_CITA")
    private Integer folioCita;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "SERVICIO")
    private String servicio;
    @Column(name = "FECHA")
    private String fecha;
    @Column(name = "HORA")
    private String hora;

    public Historialc() {
    }

    public Historialc(Integer folioCita) {
        this.folioCita = folioCita;
    }

    public Integer getFolioCita() {
        return folioCita;
    }

    public void setFolioCita(Integer folioCita) {
        this.folioCita = folioCita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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
        if (!(object instanceof Historialc)) {
            return false;
        }
        Historialc other = (Historialc) object;
        if ((this.folioCita == null && other.folioCita != null) || (this.folioCita != null && !this.folioCita.equals(other.folioCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Historialc[ folioCita=" + folioCita + " ]";
    }
    
}
