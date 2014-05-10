package bankofjava.infra;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;

import bankofjava.domain.Account;

public class AccountRepository extends Repository<Account>{

	public List<Account> get(String email, String password){
		Query query = session.createQuery("from Account account where email=:email and password=:password"); 
		query.setParameter("email", email);
		query.setParameter("password", password);
		
		return query.list();
	}

}
