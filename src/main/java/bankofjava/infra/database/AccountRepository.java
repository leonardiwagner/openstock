package bankofjava.infra.database;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;

import bankofjava.domain.Account;
import bankofjava.domain.Stock;

public class AccountRepository extends Repository<Account>{

	public AccountRepository(DatabaseSession session) {
		super(session, Account.class);
	}
	
	public List<Stock> getTopAccounts(int count){
		Query query = session.createQuery("FROM Account ORDER BY balance DESC");
		query.setMaxResults(count);
		return query.list();
	}
	

	

}
