package bankofjava.infra;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Database {

	private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
        	 Configuration configuration=new AnnotationConfiguration()
             .configure(); // configures settings from hibernate.cfg.xml

		     StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		
		     // If you miss the below line then it will complaing about a missing dialect setting
		     serviceRegistryBuilder.applySettings(configuration.getProperties());
		
		     ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		     return configuration.buildSessionFactory(serviceRegistry);
		}
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
