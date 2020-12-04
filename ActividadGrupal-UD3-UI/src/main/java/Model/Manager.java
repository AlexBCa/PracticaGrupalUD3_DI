package Model;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;




public class Manager {
	protected SessionFactory sessionFactory;
	 
    public void setup() {
        // code to load Hibernate Session factory
    	HibernateUtil hu = new HibernateUtil();
    	sessionFactory = hu.getSessionFactory();
    	Session session = sessionFactory.openSession();
    	//session.beginTransaction();
    	
    	//session.getTransaction().commit();
    	//session.close();
    	
    }
 
    public void exit() {
        // code to close Hibernate Session factory
    	
    	sessionFactory.close();
    	
    }
 
    public void create(Servicio serv) {
        // code to save a book
    	
    	
    	Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(serv);
        
        session.getTransaction().commit();
        session.close();
    	
    }
 
    public void read(int servicioId) {
        // code to get a book
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
        // code to modify a book
    	Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.update(serv);
        
        session.getTransaction().commit();
        session.close();
    	
    }
 
    public void delete(Servicio serv) {
        // code to remove a book
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	 
    	session.delete(serv);
    	 
    	session.getTransaction().commit();
    	session.close();
    }
    /*
    public static void main(String[] args) {
        AlumnoManager manager = new AlumnoManager();
        manager.setup();
        Alumno alum = new Alumno();
        
    	alum.setNombre("Ana");
    	alum.setApellido1("Jamona");
    	alum.setApellido2("Rodriguez");
    	alum.setCurso("Dibujo");
    	alum.setEdad(29);
    	alum.setNumAsignaturas(1);
        
        //manager.create(alum);
    	manager.read(3);
    	//manager.update(alum);
    	
    	manager.read(2);
    	//manager.delete(alum);
     
        manager.exit();
    }
    */
    public List<Servicio> findAllServicios() {
    	
    	Session session = sessionFactory.openSession();
    	
    	 
    	List<Servicio> ser = session.createQuery("SELECT a FROM Servicio a", Servicio.class).getResultList();
    	 
    	
    	session.close();
        return ser;     
    }
    
  
 
    
}
