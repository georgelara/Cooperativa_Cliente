package ar.com.cooperativa.java.repositories.interfaces;
import ar.com.cooperativa.java.entities.Movimiento;
import ar.com.cooperativa.java.entities.Cuenta;
import ar.com.cooperativa.java.enumerados.Tipos;
import java.util.Date;
import java.util.List;
public interface I_MovimientoR{
    void save(Movimiento movimiento);
    void remove(Movimiento movimiento);
    void update(Movimiento movimiento);
    List<Movimiento>getAll();
    Movimiento getById(int id);
    List<Movimiento>getLikeFecha(Date Fecha);
    List<Movimiento>getLikeTipo(Tipos tipo);
    List<Movimiento>getByCuenta(Cuenta cuenta);
    List<Movimiento>getByIdCuenta(int idCuenta);
}
