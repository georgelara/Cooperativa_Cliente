package ar.com.cooperativa.java.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import ar.com.cooperativa.java.enumerados.Lugares;

@Entity
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findById", query = "SELECT c FROM Cliente c WHERE c.id = :id")
    , @NamedQuery(name = "Cliente.findByLegajo", query = "SELECT c FROM Cliente c WHERE c.legajo = :legajo")
    , @NamedQuery(name = "Cliente.findByCuil", query = "SELECT c FROM Cliente c WHERE c.cuil = :cuil")
    , @NamedQuery(name = "Cliente.findBySocioNro", query = "SELECT c FROM Cliente c WHERE c.socioNro = :socioNro")
    , @NamedQuery(name = "Cliente.findByApellido", query = "SELECT c FROM Cliente c WHERE c.apellido = :apellido")
    , @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cliente.findByLugar", query = "SELECT c FROM Cliente c WHERE c.lugar = :lugar")
    , @NamedQuery(name = "Cliente.findByCbu", query = "SELECT c FROM Cliente c WHERE c.cbu = :cbu")
    , @NamedQuery(name = "Cliente.findByEmail", query = "SELECT c FROM Cliente c WHERE c.email = :email")
    , @NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "legajo")
    private int legajo;
    @Basic(optional = false)
    @Column(name = "cuil")
    private String cuil;
    @Basic(optional = false)
    @Column(name = "socioNro")
    private String socioNro;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "lugar")
    private String lugar;
    @Column(name = "cbu")
    private String cbu;
    @Column(name = "email")
    private String email;
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(mappedBy = "idCliente")
    private List<Cuenta> cuentaList;

    public Cliente() {
    }

    public Cliente(Integer id) {
        this.id = id;
    }

    public Cliente(Integer id, int legajo, String cuil, String socioNro, String apellido, String nombre, Lugares lugar, String cbu, String email, String telefono) {
        this.id = id;
        this.legajo = legajo;
        this.cuil = cuil;
        this.socioNro = socioNro;
        this.apellido = apellido;
        this.nombre = nombre;
        this.lugar = lugar.toString();
        this.cbu = cbu;
        this.email = email;
        this.telefono = telefono;
    }   

    public Cliente(int legajo, String cuil, String socioNro, String apellido, String nombre, Lugares lugar, String cbu, String email, String telefono) {
        this.legajo = legajo;
        this.cuil = cuil;
        this.socioNro = socioNro;
        this.apellido = apellido;
        this.nombre = nombre;
        this.lugar = lugar.toString();
        this.cbu = cbu;
        this.email = email;
        this.telefono = telefono;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getSocioNro() {
        return socioNro;
    }

    public void setSocioNro(String socioNro) {
        this.socioNro = socioNro;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    
    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public List<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", legajo=" + legajo + ", cuil=" + cuil + ", socioNro=" + socioNro + ", apellido=" + apellido + ", nombre=" + nombre + ", lugar=" + lugar + ", cbu=" + cbu + ", email=" + email + ", telefono=" + telefono + '}';
    }


    
}
