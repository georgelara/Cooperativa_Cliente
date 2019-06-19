package ar.com.cooperativa.java.repositories.socket;
import ar.com.cooperativa.java.entities.Cliente;
import ar.com.cooperativa.java.entities.Cuenta;
import ar.com.cooperativa.java.enumerados.Lugares;
import ar.com.cooperativa.java.repositories.interfaces.I_CuentaR;
import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;
public class CuentaR implements I_CuentaR {
    private GenericR<Cuenta>gr;
    public CuentaR(String host,List<Integer>ports){ 
        gr=new GenericR(host,ports,new Cuenta());  
    }
    @Override public void save(Cuenta cuenta)   { gr.save(cuenta);          }
    @Override public void remove(Cuenta cuenta) { gr.remove(cuenta);        }
    @Override public void update(Cuenta cuenta) { gr.update(cuenta);        }
    @Override public List<Cuenta> getAll()      { return gr.getAll();       }
    @Override public Cuenta getById(int id) {
    List<Cuenta> lista=getAll()
                .stream()
                .filter(a->a.getId()==id)
                .collect(Collectors.toList());
        return (lista==null || lista.isEmpty())?null:lista.get(0);
    }
    @Override
    public List<Cuenta> getByCliente(Cliente cliente) {
        return getByIdCliente(cliente.getId());
    }

    @Override
    public List<Cuenta> getByIdCliente(int idCliente) {
        return getAll()
                .stream()
                .filter(a->a.getIdCliente()==idCliente)
                .collect(Collectors.toList());
    }

    @Override
    public List<Cuenta> getLikeActiva(boolean activa) {
        return getAll()
                .stream()
                .filter(a->a.getActiva()==activa)
                .collect(Collectors.toList());
    }   
}