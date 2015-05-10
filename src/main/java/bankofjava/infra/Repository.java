package bankofjava.infra;

import java.util.List;
import org.hibernate.Session;

public abstract class Repository<T>{
	protected Session session;
	
	public Repository(DatabaseSession session){
		this.session = session.getSession();
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
