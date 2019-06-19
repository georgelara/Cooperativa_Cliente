/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.cooperativa.java.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author george
 */
@Entity
@Table(name = "prestamos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamo.findAll", query = "SELECT p FROM Prestamo p")
    , @NamedQuery(name = "Prestamo.findById", query = "SELECT p FROM Prestamo p WHERE p.id = :id")
    , @NamedQuery(name = "Prestamo.findByMontoTotal", query = "SELECT p FROM Prestamo p WHERE p.montoTotal = :montoTotal")
    , @NamedQuery(name = "Prestamo.findByCuotaTotal", query = "SELECT p FROM Prestamo p WHERE p.cuotaTotal = :cuotaTotal")
    , @NamedQuery(name = "Prestamo.findByCancelado", query = "SELECT p FROM Prestamo p WHERE p.cancelado = :cancelado")
    , @NamedQuery(name = "Prestamo.findByTasa", query = "SELECT p FROM Prestamo p WHERE p.tasa = :tasa")
    , @NamedQuery(name = "Prestamo.findByFecha", query = "SELECT p FROM Prestamo p WHERE p.fecha = :fecha")})
public class Prestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "montoTotal")
    private double montoTotal;
    @Basic(optional = false)
    @Column(name = "cuotaTotal")
    private int cuotaTotal;
    @Basic(optional = false)
    @Column(name = "cancelado")
    private boolean cancelado;
    @Basic(optional = false)
    @Column(name = "tasa")
    private double tasa;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrestamo")
    private List<Cuota> cuotaList;
    @JoinColumn(name = "idCuenta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cuenta idCuenta;

    public Prestamo() {
    }

    public Prestamo(Integer id) {
        this.id = id;
    }

/*
    public Prestamo(Cuenta idCuenta, double montoTotal, int cuotaTotal, boolean cancelado, double tasa, Date fecha) {
        this.idCuenta = idCuenta;
        this.montoTotal = montoTotal;
        this.cuotaTotal = cuotaTotal;
        this.cancelado = cancelado;
        this.tasa = tasa;
        this.fecha = fecha;
    }
    */

    public Prestamo(Integer id, Cuenta idCuenta, double montoTotal, int cuotaTotal, boolean cancelado, double tasa, Date fecha) {
        this.id = id;
        this.idCuenta = idCuenta;
        this.montoTotal = montoTotal;
        this.cuotaTotal = cuotaTotal;
        this.cancelado = cancelado;
        this.tasa = tasa;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public int getCuotaTotal() {
        return cuotaTotal;
    }

    public void setCuotaTotal(int cuotaTotal) {
        this.cuotaTotal = cuotaTotal;
    }

    public boolean getCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<Cuota> getCuotaList() {
        return cuotaList;
    }

    public void setCuotaList(List<Cuota> cuotaList) {
        this.cuotaList = cuotaList;
    }

/*    public Cuenta getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Cuenta idCuenta) {
        this.idCuenta = idCuenta;
    }
*/
    public int getIdCuenta() {
        return idCuenta.getId();
    }

    public void setIdCuenta(Cuenta idCUenta) {
        this.idCuenta = idCuenta;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamo)) {
            return false;
        }
        Prestamo other = (Prestamo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "id=" + id + ", idCuenta=" + idCuenta + ", montoTotal=" + montoTotal + ", cuotaTotal=" + cuotaTotal + ", cancelado=" + cancelado + ", tasa=" + tasa + ", fecha=" + fecha + '}';
    }


    
}
