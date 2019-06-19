package ar.com.cooperativa.java.repositories.jpa;
import ar.com.cooperativa.java.entities.Movimiento;
import ar.com.cooperativa.java.entities.Cuenta;
import ar.com.cooperativa.java.enumerados.Tipos;
import ar.com.cooperativa.java.repositories.interfaces.I_MovimientoR;
import ar.com.cooperativa.java.repositories.interfaces.I_GenericR;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
public class MovimientoR implements I_MovimientoR{
    private I_GenericR<Movimiento> gr;
    public MovimientoR(EntityManager em){ gr=new GenericR(em,new Movimiento());    }
    @Override public void save(Movimiento movimiento)   { gr.save(movimiento);          }
    @Override public void remove(Movimiento movimiento) { gr.remove(movimiento);        }
    @Override public void update(Movimiento movimiento) { gr.update(movimiento);        }
    @Override public List<Movimiento> getAll()      { return gr.getAll();       }
    @Override public Movimiento getById(int id) {
    List<Movimiento> lista=getAll()
                .stream()
                .filter(a->a.getId()==id)
                .collect(Collectors.toList());
        return (lista==null || lista.isEmpty())?null:lista.get(0);
    }

    @Override
    public List<Movimiento> getByCuenta(Cuenta cuenta) {
        return getByIdCuenta(cuenta.getId());
    }

    @Override
    public List<Movimiento> getByIdCuenta(int idCuenta) {
        return getAll()
                .stream()
                .filter(a->a.getIdCuenta()==idCuenta)
                .collect(Collectors.toList());
    }

    @Override
    public List<Movimiento> getLikeFecha(Date fecha) {
        return getAll()
                .stream()
                .filter(a->a.getFecha().equals(fecha))
                .collect(Collectors.toList());    }

    @Override
    public List<Movimiento> getLikeTipo(Tipos tipo) {
        return getAll()
                .stream()
                .filter(a->a.getTipo().contains(tipo.toString()))
                .collect(Collectors.toList());
    }
    
}