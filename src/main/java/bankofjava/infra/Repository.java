package bankofjava.infra;

import org.hibernate.Session;

public class Repository<T> {
	private Session session;
	
	public Repository(Database database){
		this.session = database.getCurrentSession();
	}
	
	public void save(T entity){
		session.beginTransaction();
		session.saveOrUpdate(entity);
		session.getTransaction().commit();
		
	}
	
	public void delete(T entity){
		session.delete(entity);
	}
	
}
