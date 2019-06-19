package ar.com.cooperativa.java.test;
import ar.com.cooperativa.java.entities.*;
import ar.com.cooperativa.java.enumerados.Lugares;
import ar.com.cooperativa.java.repositories.socket.*;
import java.util.ArrayList;
import java.util.List;
public class TestSocketRepository {
    public static void main(String[] args) {
        String host="localhost";
        List<Integer>ports=new ArrayList();
        List<Integer>ports2=new ArrayList();
        ports=new ArrayList();
        ports.add(8101);
        ports.add(8102);
        ports.add(8103);
        ports.add(8104);
        
        ClienteR cli=new ClienteR(host,ports);
        Cliente cliente1=new Cliente(987273, "21-31991377-9", "6130", "Lara", "George", Lugares.Administracion, "", "", "");
        Cliente cliente2=new Cliente(986892, "20-70707070-4", "9510", "Cata", "Damian", Lugares.Pilar, "", "", "");
        cli.save(cliente1);
        cli.save(cliente2);
        
        cli.getAll().forEach(System.out::println);
        System.out.println("**********************");
        System.out.println("el cliente del legajo 987273 es "+cli.getByLegajo(987273).getApellido()+", "+cli.getByLegajo(987273).getNombre());
        System.out.println("el cliente del legajo 986892 es "+cli.getByLegajo(986892).getApellido()+", "+cli.getByLegajo(986892).getNombre());
        System.out.println("****************************************************************************************");
        
        ports2=new ArrayList();
        ports2.add(8201);
        ports2.add(8202);
        ports2.add(8203);
        ports2.add(8204);
        
        CuentaR cue=new CuentaR(host,ports2);
        Cuenta cuenta1=new Cuenta(cli.getByLegajo(987273), 1550.50, true);
        cue.save(cuenta1);
        Cuenta cuenta2=new Cuenta(cli.getByLegajo(986892), 0, false);
        cue.save(cuenta2);
        
        cue.getAll().forEach(System.out::println);
        System.out.println("********************************");
        cue.getLikeActiva(false).forEach(System.out::println);
        
 
    }
}