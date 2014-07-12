package bankofjava.infra;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Database {

	private SessionFactory sessionFactory;
	
	private static Session _session = null;
	
	public static Session getOpenSession(){
		if(_session == null){
			Configuration configuration=new AnnotationConfiguration()
	        .configure("hibernate.cfg.xml"); // configures settings from hibernate.cfg.xml
	
		     StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		
		     // If you miss the below line then it will complaing about a missing dialect setting
		     serviceRegistryBuilder.applySettings(configuration.getProperties());
		
		     ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		     SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		     
		     _session = sessionFactory.openSession();
	     }
		
		return _session;
	}
	
	public Database(){
		Configuration configuration=new AnnotationConfiguration()
        .configure(); // configures settings from hibernate.cfg.xml

	     StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
	
	     // If you miss the below line then it will complaing about a missing dialect setting
	     serviceRegistryBuilder.applySettings(configuration.getProperties());
	
	     ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
	     this.sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
    public Session getSession() {
        return this.sessionFactory.openSession();
    }
}
