package bankofjava.infra.database;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import javax.persistence.Table;


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
	
	public void save(T entity){
		save(entity, false);
	}
	
	public void save(T entity, boolean autoCommit){
		if(autoCommit) session.beginTransaction();
		session.saveOrUpdate(entity);
		if(autoCommit) session.getTransaction().commit();
	}
	
	public void delete(T entity){
		delete(entity, false);
	}
	
	public void delete(T entity, boolean autoCommit){
		if(autoCommit) session.beginTransaction();
		session.delete(entity);
		if(autoCommit) session.getTransaction().commit();
	}

	public void deleteAll(){
		deleteAll(false);
	}
	
	public void deleteAll(boolean autoCommit){
		Table table = typeParameterClass.getAnnotation(Table.class);
		session.createSQLQuery("delete from " + table.name()).executeUpdate();
	}
	
	public void beginTransaction(){
		session.beginTransaction();
	}
	
	public void commitTransaction(){
		session.getTransaction().commit();
	}
	
	
}
