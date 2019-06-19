package ar.com.cooperativa.java.repositories.jpa;
import ar.com.cooperativa.java.entities.Cuota;
import ar.com.cooperativa.java.entities.Prestamo;
import ar.com.cooperativa.java.enumerados.Tipos;
import ar.com.cooperativa.java.repositories.interfaces.I_CuotaR;
import ar.com.cooperativa.java.repositories.interfaces.I_GenericR;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
public class CuotaR implements I_CuotaR{
    private I_GenericR<Cuota> gr;
    public CuotaR(EntityManager em){ gr=new GenericR(em,new Cuota());    }
    @Override public void save(Cuota cuota)   { gr.save(cuota);          }
    @Override public void remove(Cuota cuota) { gr.remove(cuota);        }
    @Override public void update(Cuota cuota) { gr.update(cuota);        }
    @Override public List<Cuota> getAll()      { return gr.getAll();       }
    @Override public Cuota getById(int id) {
    List<Cuota> lista=getAll()
                .stream()
                .filter(a->a.getId()==id)
                .collect(Collectors.toList());
        return (lista==null || lista.isEmpty())?null:lista.get(0);
    }

    @Override
    public List<Cuota> getByPrestamo(Prestamo prestamo) {
        return getByIdPrestamo(prestamo.getId());
    }

    @Override
    public List<Cuota> getByIdPrestamo(int idPrestamo) {
        return getAll()
                .stream()
                .filter(a->a.getIdPrestamo()==idPrestamo)
                .collect(Collectors.toList());
    }

    @Override
    public List<Cuota> getLikeFecha(Date fecha) {
        return getAll()
                .stream()
                .filter(a->a.getFecha().equals(fecha))
                .collect(Collectors.toList());    }

    @Override
    public List<Cuota> getLikePagado(boolean pagado) {
        return getAll()
                .stream()
                .filter(a->a.getPagado()==pagado)
                .collect(Collectors.toList());
    }

    @Override
    public List<Cuota> getLikeCuotaNro(int cuotaNro) {
        return getAll()
                .stream()
                .filter(a->a.getCuotaNro()==cuotaNro)
                .collect(Collectors.toList());
    }
    
}