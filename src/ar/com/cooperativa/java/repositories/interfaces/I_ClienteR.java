package ar.com.cooperativa.java.repositories.interfaces;
import ar.com.cooperativa.java.entities.Cliente;
import java.util.List;
public interface I_ClienteR{
    void save(Cliente cliente);
    void remove(Cliente cliente);
    void update(Cliente cliente);
    List<Cliente>getAll();
    Cliente getById(int id);
    Cliente getByLegajo(int legajo);
    List<Cliente>getLikeApellido(String apellido);
    List<Cliente>getLikeCuil(String cuil);
    List<Cliente>getLikeApellidoNombre(String apellido,String nombre);
}
