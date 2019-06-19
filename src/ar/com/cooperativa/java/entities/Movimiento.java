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
import ar.com.cooperativa.java.enumerados.Tipos;
import ar.com.cooperativa.java.repositories.jpa.ClienteR;
import ar.com.cooperativa.java.repositories.jpa.CuentaR;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author george
 */
@Entity
@Table(name = "movimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimiento.findAll", query = "SELECT m FROM Movimiento m")
    , @NamedQuery(name = "Movimiento.findById", query = "SELECT m FROM Movimiento m WHERE m.id = :id")
    , @NamedQuery(name = "Movimiento.findByTipo", query = "SELECT m FROM Movimiento m WHERE m.tipo = :tipo")
    , @NamedQuery(name = "Movimiento.findByMonto", query = "SELECT m FROM Movimiento m WHERE m.monto = :monto")
    , @NamedQuery(name = "Movimiento.findByFecha", query = "SELECT m FROM Movimiento m WHERE m.fecha = :fecha")})
public class Movimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "monto")
    private double monto;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idCuenta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cuenta idCuenta;

    public Movimiento() {
    }

    public Movimiento(Integer id) {
        this.id = id;
    }

    public Movimiento(Cuenta idCuenta, Tipos tipo, double monto, Date fecha) {
        this.idCuenta = idCuenta;
        this.tipo = tipo.toString();
        this.monto = monto;
        this.fecha = fecha;
    }
    
    public Movimiento(Integer id, Cuenta idCuenta, Tipos tipo, double monto, Date fecha) {
        this.id=id;
        this.idCuenta = idCuenta;
        this.tipo = tipo.toString();
        this.monto = monto;
        this.fecha = fecha;
    }


    public Movimiento(Integer id, Cuenta idCuenta, String tipo, double monto, Date fecha) {
        this.id = id;
        this.idCuenta = idCuenta;
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = fecha;
    }
    
    


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    public Cuenta getCuenta() {
        return idCuenta;
    }
/*
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
        if (!(object instanceof Movimiento)) {
            return false;
        }
        Movimiento other = (Movimiento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "id=" + id + ", idCuenta=" + idCuenta +", tipo=" + tipo + ", monto=" + monto + ", fecha=" + fecha +  '}';
    }

    public void movimientos(){
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("COOPU");
        EntityManager em=emf.createEntityManager();
//        ClienteR cli=new ClienteR(em);
        CuentaR cue=new CuentaR(em);
        if(this.tipo.toString().equals(Tipos.Aporte.toString())||
                this.tipo.toString().equals(Tipos.Diferencial.toString())){
            this.idCuenta.setSaldo(this.idCuenta.getSaldo()+this.monto);
            System.out.println("se acredito $"+this.monto+" de la cuenta de: "+this.getCuenta());
            cue.update(cue.getById(this.getIdCuenta()));
        }
        if(this.tipo.toString().equals(Tipos.Reintegro.toString())){
            this.idCuenta.setSaldo(this.idCuenta.getSaldo()-this.monto);
            System.out.println("se desconto $"+this.monto+" de la cuenta de: "+this.getCuenta());
            cue.update(cue.getById(this.getIdCuenta()));
        }
   
    }

    
}
