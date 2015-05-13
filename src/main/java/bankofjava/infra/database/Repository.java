package bankofjava.infra.database;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.jinq.jpa.JinqJPAStreamProvider;

public abstract class Repository<T>{
	protected final Session session;
	protected final Class<T> typeParameterClass;
					  
	public Repository(DatabaseSession session, Class<T> typeParameterClass){
		this.session = session.getSession();
		this.typeParameterClass = typeParameterClass;
	}
	
	public T getById(int id){
		return (T) session.get(typeParameterClass, id);
	}
	
	public List<T> getAll(){
		return session.createCriteria(typeParameterClass).list();
	}
	
	public T save(T entity){
		session.saveOrUpdate(entity);
		return entity;
	}
	
	public void delete(T entity){
		session.delete(entity);
	}
	
	
}
