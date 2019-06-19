package ar.com.cooperativa.java.repositories.jpa;
import ar.com.cooperativa.java.entities.Cliente;
import ar.com.cooperativa.java.repositories.interfaces.I_ClienteR;
import ar.com.cooperativa.java.repositories.interfaces.I_GenericR;
import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
public class ClienteR implements I_ClienteR{
    private I_GenericR<Cliente> gr;
    public ClienteR(EntityManager em){ gr=new GenericR(em,new Cliente());    }
    @Override public void save(Cliente cliente)   { gr.save(cliente);          }
    @Override public void remove(Cliente cliente) { gr.remove(cliente);        }
    @Override public void update(Cliente cliente) { gr.update(cliente);        }
    @Override public List<Cliente> getAll()      { return gr.getAll();       }
    @Override public Cliente getById(int id) {
    List<Cliente> lista=getAll()
                .stream()
                .filter(a->a.getId()==id)
                .collect(Collectors.toList());
        return (lista==null || lista.isEmpty())?null:lista.get(0);
    }
@Override public Cliente getByLegajo(int legajo) {
    List<Cliente> lista=getAll()
                .stream()
                .filter(a->a.getLegajo()==legajo)
                .collect(Collectors.toList());
        return (lista==null || lista.isEmpty())?null:lista.get(0);
    }
    @Override public List<Cliente> getLikeApellido(String apellido) {
        return getAll()
                .stream()
                .filter(a->a.getApellido().equalsIgnoreCase(apellido))
                .collect(Collectors.toList());
    }
    @Override public List<Cliente> getLikeApellidoNombre(String apellido, String nombre) {
        return getAll()
                .stream()
                .filter(a->a.getApellido().toLowerCase().contains(apellido.toLowerCase())
                    || a.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }
    
        @Override public List<Cliente> getLikeCuil(String cuil) {
        return getAll()
                .stream()
                .filter(a->a.getCuil().toLowerCase().contains(cuil.toLowerCase()))
                .collect(Collectors.toList());
    }

}