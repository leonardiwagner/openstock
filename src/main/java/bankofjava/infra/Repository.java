package bankofjava.infra;

import java.util.List;

import org.hibernate.Session;

public abstract class Repository<T> {
	protected Session session;
	
	public Repository(Database database){
		this.session = database.getSession();
	}
	
	public List<T> getAll(Class<T> classType){
		return session.createCriteria(classType).list();
	}
	
	public void save(T entity){
		session.beginTransaction();
		session.saveOrUpdate(entity);
		session.getTransaction().commit();
		
	}
	
	public void delete(T entity){
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
	}
	
}
