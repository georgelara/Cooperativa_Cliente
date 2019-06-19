package ar.com.cooperativa.java.repositories.socket;
import ar.com.cooperativa.java.entities.Cliente;
import ar.com.cooperativa.java.enumerados.Lugares;
import ar.com.cooperativa.java.repositories.interfaces.I_ClienteR;
import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;
public class ClienteR implements I_ClienteR {
    private GenericR<Cliente>gr;
    public ClienteR(String host,List<Integer>ports){ 
        gr=new GenericR(host,ports,new Cliente());  
    }
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