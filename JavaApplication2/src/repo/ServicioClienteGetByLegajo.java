package repo;
import ar.com.cooperativa.java.repositories.jpa.ClienteR;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class ServicioClienteGetByLegajo implements Runnable{
    private int port=8105;
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("COOPU");
    EntityManager em=emf.createEntityManager();
    ClienteR cli=new ClienteR(em);
    @Override public void run() {
        try (ServerSocket ss=new ServerSocket(port)) {
            System.out.println("Servicio Cliente GetByLegajo: OK");
            while(true){
                System.out.println("Esperando conexión de cliente...");
                try (
                        Socket so=ss.accept();
                        ObjectInputStream in=new ObjectInputStream(so.getInputStream());
                        ObjectOutputStream out=new ObjectOutputStream(so.getOutputStream());
                ){
                    System.out.println("Servicio Cliente GetByLegajo, se conecto "
                            +so.getInetAddress());
                    int legajo=(int)in.readObject();
                    out.writeObject(cli.getByLegajo(legajo));
                } catch (Exception ee) { ee.printStackTrace(); }
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}