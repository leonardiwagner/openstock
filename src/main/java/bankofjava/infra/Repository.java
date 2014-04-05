package bankofjava.infra;

import org.hibernate.Session;

public abstract class Repository<T> {
	public Session session = Database.getSessionFactory().getCurrentSession();
	
	public void insert(T entity){
		session.save(entity);
	}
	
}
