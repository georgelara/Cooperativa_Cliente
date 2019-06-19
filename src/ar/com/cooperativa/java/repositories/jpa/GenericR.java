package ar.com.cooperativa.java.repositories.jpa;
import ar.com.cooperativa.java.repositories.interfaces.I_GenericR;
import java.lang.reflect.Field;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;        
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
public class GenericR<E> implements I_GenericR<E>{
    private EntityManager em;
    private E e;
    public GenericR(EntityManager em,E e) { 
        this.em = em; 
        this.e = e;
    }
    @Override public void save(E e) {
        if(e==null) return;
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }
    @Override public void remove(E e) {
        if(e==null) return;
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }
    @Override public void update(E e) {
        if(e==null) return;  
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }
    @Override public List<E> getAll() {
        return em.
                createNamedQuery(e.getClass().getSimpleName()+".findAll")
                .getResultList();
    }
}
