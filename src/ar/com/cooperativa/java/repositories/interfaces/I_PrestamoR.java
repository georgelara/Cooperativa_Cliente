package ar.com.cooperativa.java.repositories.interfaces;
import ar.com.cooperativa.java.entities.Prestamo;
import ar.com.cooperativa.java.entities.Cuenta;
import ar.com.cooperativa.java.enumerados.Tipos;
import java.util.Date;
import java.util.List;
public interface I_PrestamoR{
    void save(Prestamo prestamo);
    void remove(Prestamo prestamo);
    void update(Prestamo prestamo);
    List<Prestamo>getAll();
    Prestamo getById(int id);
    List<Prestamo>getLikeFecha(Date Fecha);
    List<Prestamo>getLikeCancelado(boolean cancelado);
    List<Prestamo>getLikeCuotaTotal(int cuotaTotal);
    List<Prestamo>getByCuenta(Cuenta cuenta);
    List<Prestamo>getByIdCuenta(int idCuenta);
}
