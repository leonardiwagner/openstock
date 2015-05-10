package bankofjava.integration;

import org.junit.*;

import java.util.*;

import bankofjava.domain.Account;
import bankofjava.infra.*;

public class AccountTest{

	
	@Test
	public void createAccount() throws Exception{
		try(DatabaseSession session = new DatabaseSession()){
			AccountRepository repository = new AccountRepository(session);
			repository.save(new Account("test@user.com"));
		}
	}
	
	
	
}
