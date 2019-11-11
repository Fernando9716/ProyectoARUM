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
@Table(name = "DETALLE_VENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleVenta.findAll", query = "SELECT d FROM DetalleVenta d"),
    @NamedQuery(name = "DetalleVenta.findByIdDetalle", query = "SELECT d FROM DetalleVenta d WHERE d.idDetalle = :idDetalle"),
    @NamedQuery(name = "DetalleVenta.findByIdProducto", query = "SELECT d FROM DetalleVenta d WHERE d.idProducto = :idProducto"),
    @NamedQuery(name = "DetalleVenta.findByIdServicio", query = "SELECT d FROM DetalleVenta d WHERE d.idServicio = :idServicio"),
    @NamedQuery(name = "DetalleVenta.findByCantidad", query = "SELECT d FROM DetalleVenta d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleVenta.findByFolioVenta", query = "SELECT d FROM DetalleVenta d WHERE d.folioVenta = :folioVenta")})
public class DetalleVenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DETALLE")
    private Integer idDetalle;
    @Column(name = "ID_PRODUCTO")
    private Integer idProducto;
    @Column(name = "ID_SERVICIO")
    private Integer idServicio;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    @Column(name = "FOLIO_VENTA")
    private Integer folioVenta;

    public DetalleVenta() {
    }

    public DetalleVenta(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
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
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVenta)) {
            return false;
        }
        DetalleVenta other = (DetalleVenta) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.DetalleVenta[ idDetalle=" + idDetalle + " ]";
    }
    
}
