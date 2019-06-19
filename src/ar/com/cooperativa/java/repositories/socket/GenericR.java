package ar.com.cooperativa.java.repositories.socket;
import ar.com.cooperativa.java.repositories.interfaces.I_GenericR;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.Socket;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;        
import java.util.ArrayList;
public class GenericR<E> implements I_GenericR<E>{
    private String host;
    private List<Integer>ports;
    private E e;
    public GenericR(String host,List<Integer> ports, E e) { 
        this.host=host;
        this.ports=ports;
        this.e=e;
    }
    @Override public void save(E e) {
        try(
            Socket so=new Socket(host,ports.get(0));
            ObjectOutputStream out=new ObjectOutputStream(so.getOutputStream());
            ObjectInputStream in=new ObjectInputStream(so.getInputStream());
        ){
            out.writeObject(e);
            //Object obj=in.readObject();
        }catch(Exception ee) { ee.printStackTrace(); }
    }
    @Override public void remove(E e) {
        try(
            Socket so=new Socket(host,ports.get(1));
            ObjectOutputStream out=new ObjectOutputStream(so.getOutputStream());
            ObjectInputStream in=new ObjectInputStream(so.getInputStream());
        ){
            out.writeObject(e);
            //in.readObject();
        }catch(Exception ee) { ee.printStackTrace(); }
    }
    @Override public void update(E e) {
        
    }
    @Override public List<E> getAll() {
        List<E>lista=new ArrayList();
       try(
            Socket so=new Socket(host,ports.get(2));
            ObjectInputStream in=new ObjectInputStream(so.getInputStream());
        ){
            lista=(List<E>)in.readObject();
        }catch(Exception ee) { ee.printStackTrace(); }
       return lista;
    }
}
