package ar.com.cooperativa.java.repositories.jpa;
import ar.com.cooperativa.java.entities.Prestamo;
import ar.com.cooperativa.java.entities.Cuenta;
import ar.com.cooperativa.java.enumerados.Tipos;
import ar.com.cooperativa.java.repositories.interfaces.I_PrestamoR;
import ar.com.cooperativa.java.repositories.interfaces.I_GenericR;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
public class PrestamoR implements I_PrestamoR{
    private I_GenericR<Prestamo> gr;
    public PrestamoR(EntityManager em){ gr=new GenericR(em,new Prestamo());    }
    @Override public void save(Prestamo prestamo)   { gr.save(prestamo);          }
    @Override public void remove(Prestamo prestamo) { gr.remove(prestamo);        }
    @Override public void update(Prestamo prestamo) { gr.update(prestamo);        }
    @Override public List<Prestamo> getAll()      { return gr.getAll();       }
    @Override public Prestamo getById(int id) {
    List<Prestamo> lista=getAll()
                .stream()
                .filter(a->a.getId()==id)
                .collect(Collectors.toList());
        return (lista==null || lista.isEmpty())?null:lista.get(0);
    }

    @Override
    public List<Prestamo> getByCuenta(Cuenta cuenta) {
        return getByIdCuenta(cuenta.getId());
    }

    @Override
    public List<Prestamo> getByIdCuenta(int idCuenta) {
        return getAll()
                .stream()
                .filter(a->a.getIdCuenta()==idCuenta)
                .collect(Collectors.toList());
    }

    @Override
    public List<Prestamo> getLikeFecha(Date fecha) {
        return getAll()
                .stream()
                .filter(a->a.getFecha().equals(fecha))
                .collect(Collectors.toList());    }

    @Override
    public List<Prestamo> getLikeCancelado(boolean cancelado) {
        return getAll()
                .stream()
                .filter(a->a.getCancelado()==cancelado)
                .collect(Collectors.toList());
    }

    @Override
    public List<Prestamo> getLikeCuotaTotal(int cuotaTotal) {
        return getAll()
                .stream()
                .filter(a->a.getCuotaTotal()==cuotaTotal)
                .collect(Collectors.toList());
    }
    
}