package Model;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

public class Manager {
	protected SessionFactory sessionFactory;
	 
    public void setup() {
    	HibernateUtil hu = new HibernateUtil();
    	sessionFactory = hu.getSessionFactory();
    }
 
    public void exit() {
    	sessionFactory.close();
    }
 
    public void create(Servicio serv) throws ConstraintViolationException {
    	Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(serv);
        
        session.getTransaction().commit();
        session.close();
    	
    }
 
    public void read(int servicioId) {
    	Session session = sessionFactory.openSession();
    	Servicio serv = (Servicio)session.get(Servicio.class, servicioId);
        System.out.println("Id: " + serv.getId());
        System.out.println("Nombre: " + serv.getNombre());
        System.out.println("Tipo: " + serv.getTipo());
        System.out.println("Prioridad: " + serv.getPrioridad());
        System.out.println("Observaciones: " + serv.getObservaciones());
        
     
        session.close();
    }
 
    public void update(Servicio serv) {
    	Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.update(serv);
        
        session.getTransaction().commit();
        session.close();
    	
    }
 
    public void delete(Servicio serv) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	 
    	session.delete(serv);
    	 
    	session.getTransaction().commit();
    	session.close();
    }

    public List<Servicio> findAllServicios() {
    	Session session = sessionFactory.openSession();
    	List<Servicio> ser = session.createQuery("SELECT a FROM Servicio a", Servicio.class).getResultList();
    	session.close();
        return ser;     
    }
    
}
