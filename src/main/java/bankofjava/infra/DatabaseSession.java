package bankofjava.infra;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DatabaseSession implements AutoCloseable{

	private  Session session = null;
	
	public DatabaseSession(){
			Configuration configuration=new AnnotationConfiguration()
	        .configure("hibernate.cfg.xml"); // configures settings from hibernate.cfg.xml
	
		     StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		
		     // If you miss the below line then it will complaing about a missing dialect setting
		     serviceRegistryBuilder.applySettings(configuration.getProperties());
		
		     ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		     SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		     
		     session = sessionFactory.openSession();
		     
		     session.beginTransaction();
	  
	}
	
	public Session getSession(){
		return this.session;
	}
	


	@Override
	public void close() throws Exception {
		session.getTransaction().commit();
	}
}
