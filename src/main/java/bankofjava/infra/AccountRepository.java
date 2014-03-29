package bankofjava.infra;

import org.hibernate.*;

import bankofjava.domain.Account;

public class AccountRepository {

	public void insert(Account account){
		Session session = Database.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(account);
		session.getTransaction().commit();
	}
}
