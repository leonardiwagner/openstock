package bankofjava.integration;

import org.junit.*;

import java.util.*;

import bankofjava.domain.Account;
import bankofjava.infra.*;
import bankofjava.infra.database.AccountRepository;
import bankofjava.infra.database.DatabaseSession;

public class AccountTest{

	
	@Test
	public void createAccount() throws Exception{
		try(DatabaseSession session = new DatabaseSession()){
			AccountRepository repository = new AccountRepository(session);
			repository.save(new Account("test@user.com"));
		}
	}
	
	
	
}
