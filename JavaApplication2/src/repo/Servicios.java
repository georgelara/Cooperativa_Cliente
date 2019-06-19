package repo;

import repo.ServicioClienteGetByLegajo;
import repo.ServicioClienteGetLikeApellido;
import repo.ServicioClienteGetLikeCuil;
import repo.ServicioCuentaGetLikeActiva;
import repo.ServicioCuentaGetByCliente;
import repo.ServicioCuentaGetByIdCliente;

public class Servicios {
    public static void main(String[] args) {
        new Thread(new ServicioClienteSave()).start();
        new Thread(new ServicioClienteGetAll()).start();
        new Thread(new ServicioClienteRemove()).start();
        new Thread(new ServicioClienteUpdate()).start();
        new Thread(new ServicioClienteGetByLegajo()).start();
        new Thread(new ServicioClienteGetLikeApellido()).start();
        new Thread(new ServicioClienteGetLikeCuil()).start();

        new Thread(new ServicioCuentaSave()).start();
        new Thread(new ServicioCuentaGetAll()).start();
        new Thread(new ServicioCuentaRemove()).start();
        new Thread(new ServicioCuentaUpdate()).start();
        new Thread(new ServicioCuentaGetLikeActiva()).start();
        new Thread(new ServicioCuentaGetByCliente()).start();
        new Thread(new ServicioCuentaGetByIdCliente()).start();

    }
}
