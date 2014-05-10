package bankofjava.infra;

import java.util.List;
import org.hibernate.Session;

public abstract class Repository<T> {
	protected Session session;
	
	public Repository(){
		this.session = Database.getOpenSession();
	}
	
	public T getById(Class<T> classType, int id){
		return (T) session.get(classType, id);
	}
	
	public List<T> getAll(Class<T> classType){
		return session.createCriteria(classType).list();
	}
	
	public T save(T entity){
		session.beginTransaction();
		session.saveOrUpdate(entity);
		session.getTransaction().commit();
		return entity;
	}
	
	public void delete(T entity){
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
	}
	
}
