package ar.com.cooperativa.java.repositories.interfaces;
import ar.com.cooperativa.java.entities.Cuota;
import ar.com.cooperativa.java.entities.Prestamo;
import java.util.Date;
import java.util.List;
public interface I_CuotaR{
    void save(Cuota cuota);
    void remove(Cuota cuota);
    void update(Cuota cuota);
    List<Cuota>getAll();
    Cuota getById(int id);
    List<Cuota>getLikeFecha(Date Fecha);
    List<Cuota>getLikePagado(boolean pagado);
    List<Cuota>getLikeCuotaNro(int cuotaNro);
    List<Cuota>getByPrestamo(Prestamo prestamo);
    List<Cuota>getByIdPrestamo(int idPrestamo);
}
