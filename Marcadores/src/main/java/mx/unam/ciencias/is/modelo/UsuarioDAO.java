/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.modelo;
import mx.unam.ciencias.is.mapeobd.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author jonathan
 */
public class UsuarioDAO {
    
    /*Sesion para conectarnos a la base de datos*/
    private SessionFactory sessionFactory;
    
    /**
     * Inicialisamos la sesion a la base de datos.
     * @param sessionFactory 
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    /**
     * Guarda un marcador a la base de datos 
     * @param marcador el usuario a guardar.
     */
    public void guardar(Usuario usuario) {
        //se inicia la sesion
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //guardamos el marcador
            session.persist(usuario);
           
            tx.commit();
        }
        catch (Exception e) {
            //Se regresa a un estado consistente 
            if (tx!=null){ 
                tx.rollback();
            }
            e.printStackTrace(); 
        }
        finally {
            //cerramos simpre la sesion
            session.close();
        }
    
    }
    
    /**
     * Regresa la lista de todos los marcadores en la base de datos
     * @return la lista que contiene a todos los marcadores de la base de datos
     */
    public List<Usuario> getUsuarios(){
        List<Usuario> usuarios = null;
        Usuario m = null;
        Session s = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            String hql = " From Marcador";
            Query query = s.createQuery(hql);
            usuarios = (List<Usuario>)query.list();
            tx.commit();
           
        }catch(Exception e){
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        //kill!
        }finally{
           s.close();
       }
       return usuarios;
    }
    
    /**
     * Regresa el marcador con la longitud  y latitud dada. 
     * @param lattitud
     * @param longitud
     * @return el marcador con la longitud y latitud dada.
     */
    public Usuario getUsuario(double latitud,double longitud) {
       Usuario m = null;
       Session s = sessionFactory.openSession();
       Transaction tx = null;
       try{
           tx = s.beginTransaction();
           String hql = " From Usuario where"
                   + "varLatitud = :lat and"
                   + "varLongitud = :long";
           Query query = s.createQuery(hql);
           query.setParameter("lat",latitud);
           query.setParameter("long",longitud);
           m = (Usuario)query.uniqueResult();
           tx.commit();
       }catch(Exception e){
           if(tx!=null)
               tx.rollback();
           e.printStackTrace();
       //kill!
       }finally{
           s.close();
       }
       return m;
    }
    
    /**
     * Regresa el marcador con el id dado
     * @param id del marcador 
     * @return el marcador con ese id
     */
    public Usuario getUsuarioId(int id) {
        Usuario m = null;
       Session s = sessionFactory.openSession();
       Transaction tx = null;
       try{
           tx = s.beginTransaction();
           String hql = " From Marcador where"
                   + "varMarcador_id = :id ";
           Query query = s.createQuery(hql);
           query.setParameter("id",id);
           m = (Usuario)query.uniqueResult();
           tx.commit();
       }catch(Exception e){
           if(tx!=null)
               tx.rollback();
           e.printStackTrace();
       //kill!
       }finally{
           s.close();
       }
       return m;
    }
    
    
    /**
     * Elimina el marcador de la base de datos
     * @param marcador el marcador a eliminar
     */
    public void eliminar(Usuario usuario) {
        //se inicia la sesion
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //guardamos el marcador
            session.delete(usuario);
           
            tx.commit();
        }
        catch (Exception e) {
            //Se regresa a un estado consistente 
            if (tx!=null){ 
                tx.rollback();
            }
            e.printStackTrace(); 
        }
        finally {
            //cerramos simpre la sesion
            session.close();
        }
    }
    
    /**
     * Actualiza el marcardor en la base de datos
     * @param marcador con los nuevos valores 
     */
    public void actualizar(Usuario usuario) {
       //se inicia la sesion
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //guardamos el marcador
            session.update(usuario);
           
            tx.commit();
        }
        catch (Exception e) {
            //Se regresa a un estado consistente 
            if (tx!=null){ 
                tx.rollback();
            }
            e.printStackTrace(); 
        }
        finally {
            //cerramos simpre la sesion
            session.close();
        }
    }
}
