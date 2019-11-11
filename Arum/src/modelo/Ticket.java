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
@Table(name = "TICKET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"),
    @NamedQuery(name = "Ticket.findByFolioTicket", query = "SELECT t FROM Ticket t WHERE t.folioTicket = :folioTicket"),
    @NamedQuery(name = "Ticket.findByFecha", query = "SELECT t FROM Ticket t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "Ticket.findByIdEmpleado", query = "SELECT t FROM Ticket t WHERE t.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Ticket.findByFolioVenta", query = "SELECT t FROM Ticket t WHERE t.folioVenta = :folioVenta")})
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FOLIO_TICKET")
    private Integer folioTicket;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "ID_EMPLEADO")
    private Integer idEmpleado;
    @Column(name = "FOLIO_VENTA")
    private Integer folioVenta;

    public Ticket() {
    }

    public Ticket(Integer folioTicket) {
        this.folioTicket = folioTicket;
    }

    public Integer getFolioTicket() {
        return folioTicket;
    }

    public void setFolioTicket(Integer folioTicket) {
        this.folioTicket = folioTicket;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getFolioVenta() {
        return folioVenta;
    }

    public void setFolioVenta(Integer folioVenta) {
        this.folioVenta = folioVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (folioTicket != null ? folioTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.folioTicket == null && other.folioTicket != null) || (this.folioTicket != null && !this.folioTicket.equals(other.folioTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Ticket[ folioTicket=" + folioTicket + " ]";
    }
    
}
