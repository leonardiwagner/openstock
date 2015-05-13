package bankofjava.infra.database;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;

import bankofjava.domain.Account;

public class AccountRepository extends Repository<Account>{

	public AccountRepository(DatabaseSession session) {
		super(session, Account.class);
	}

	

	

}
