package bankofjava.infra.database;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.jinq.jpa.JinqJPAStreamProvider;

public abstract class Repository<T>{
	protected Session session;
	private Class<T> typeParameterClass;
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
	JinqJPAStreamProvider streams =  new JinqJPAStreamProvider(entityManagerFactory);
	
					  
	public Repository(DatabaseSession session, Class<T> typeParameterClass){
		this.session = session.getSession();
		this.typeParameterClass = typeParameterClass;
		
		EntityManager em = em = entityManagerFactory.createEntityManager();
		List<T> customers = streams
				  .streamAll(em, typeParameterClass)
				  .where( c -> c.getName().equals("Bob") )
				  .toList();
	}
	
	public T getById(Class<T> classType, int id){
		return (T) session.get(classType, id);
	}
	
	public List<T> getAll(Class<T> classType){
		return session.createCriteria(classType).list();
	}
	
	public T save(T entity){
		session.saveOrUpdate(entity);
		return entity;
	}
	
	public void delete(T entity){
		session.delete(entity);
	}
	
	
}
