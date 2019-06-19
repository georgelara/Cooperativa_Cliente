package ar.com.cooperativa.java.repositories.interfaces;
import ar.com.cooperativa.java.entities.Cuenta;
import ar.com.cooperativa.java.entities.Cliente;
import java.util.List;
public interface I_CuentaR{
    void save(Cuenta cuenta);
    void remove(Cuenta cuenta);
    void update(Cuenta cuenta);
    List<Cuenta>getAll();
    Cuenta getById(int id);
    List<Cuenta>getLikeActiva(boolean activa);
    List<Cuenta>getByCliente(Cliente cliente);
    List<Cuenta>getByIdCliente(int idCliente);
}
