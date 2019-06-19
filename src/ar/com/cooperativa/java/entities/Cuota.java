/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.cooperativa.java.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author george
 */
@Entity
@Table(name = "cuotas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuota.findAll", query = "SELECT c FROM Cuota c")
    , @NamedQuery(name = "Cuota.findById", query = "SELECT c FROM Cuota c WHERE c.id = :id")
    , @NamedQuery(name = "Cuota.findByCuotaNro", query = "SELECT c FROM Cuota c WHERE c.cuotaNro = :cuotaNro")
    , @NamedQuery(name = "Cuota.findByValor", query = "SELECT c FROM Cuota c WHERE c.valor = :valor")
    , @NamedQuery(name = "Cuota.findByPagado", query = "SELECT c FROM Cuota c WHERE c.pagado = :pagado")
    , @NamedQuery(name = "Cuota.findByFecha", query = "SELECT c FROM Cuota c WHERE c.fecha = :fecha")})
public class Cuota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "cuotaNro")
    private int cuotaNro;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @Column(name = "pagado")
    private boolean pagado;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idPrestamo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Prestamo idPrestamo;

    public Cuota() {
    }

    public Cuota(Integer id) {
        this.id = id;
    }

    public Cuota(Prestamo idPrestamo, int cuotaNro, double valor, boolean pagado, Date fecha) {
        this.idPrestamo = idPrestamo;
        this.cuotaNro = cuotaNro;
        this.valor = valor;
        this.pagado = pagado;
        this.fecha = fecha;
    }

    public Cuota(Integer id, Prestamo idPrestamo, int cuotaNro, double valor, boolean pagado, Date fecha) {
        this.id=id;
        this.idPrestamo = idPrestamo;
        this.cuotaNro = cuotaNro;
        this.valor = valor;
        this.pagado = pagado;
        this.fecha = fecha;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCuotaNro() {
        return cuotaNro;
    }

    public void setCuotaNro(int cuotaNro) {
        this.cuotaNro = cuotaNro;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean getPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public int getIdPrestamo() {
        return idPrestamo.getId();
    }

    public void setIdPrestamo(Prestamo idPrestamo) {
        this.idPrestamo = idPrestamo;
    }
/*    
    public Prestamo getIdPrestamo() {
        return idPrestamo;
    }

     public void setIdPrestamo(Prestamo idPrestamo) {
        this.idPrestamo = idPrestamo;
    }
*/
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuota)) {
            return false;
        }
        Cuota other = (Cuota) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cuota{" + "id=" + id + ", idPrestamo=" + idPrestamo +", cuotaNro=" + cuotaNro + ", valor=" + valor + ", pagado=" + pagado + ", fecha=" + fecha +  '}';
    }


    
}
