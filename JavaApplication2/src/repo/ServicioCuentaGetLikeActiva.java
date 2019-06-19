package repo;
import ar.com.cooperativa.java.repositories.jpa.CuentaR;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class ServicioCuentaGetLikeActiva implements Runnable{
    private int port=8205;
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("COOPU");
    EntityManager em=emf.createEntityManager();
    CuentaR cue=new CuentaR(em);
    @Override public void run() {
        try (ServerSocket ss=new ServerSocket(port)) {
            System.out.println("Servicio Cuenta GetLikeActiva: OK");
            while(true){
                System.out.println("Esperando conexión de cueente...");
                try (
                        Socket so=ss.accept();
                        ObjectInputStream in=new ObjectInputStream(so.getInputStream());
                        ObjectOutputStream out=new ObjectOutputStream(so.getOutputStream());
                ){
                    System.out.println("Servicio Cuenta GetLikeActiva, se conecto "
                            +so.getInetAddress());
                    boolean activa=(boolean)in.readObject();
                    out.writeObject(cue.getLikeActiva(activa));
                } catch (Exception ee) { ee.printStackTrace(); }
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}