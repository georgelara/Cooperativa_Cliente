package ar.com.cooperativa.java.test;
import ar.com.cooperativa.java.entities.Cliente;
import ar.com.cooperativa.java.enumerados.Lugares;
import ar.com.cooperativa.java.repositories.socket.ClienteR;
import java.util.ArrayList;
import java.util.List;
public class TestSocketRepository {
    public static void main(String[] args) {
        String host="localhost";
        List<Integer>ports=new ArrayList();
        ports=new ArrayList();
        ports.add(8101);
        ports.add(8102);
        ports.add(8103);
        ports.add(8104);
        ports.add(8105);
        ports.add(8106);
        ports.add(8107);
        
        ClienteR cli=new ClienteR(host,ports);
        Cliente cliente=new Cliente(987073, "20-70707070-4", "9510", "Cata", "Damian", Lugares.Pilar, "", "", "");
        cli.save(cliente);
        
        cli.getAll().forEach(System.out::println);
        cli.getByLegajo(987272);
        
        
    }
}