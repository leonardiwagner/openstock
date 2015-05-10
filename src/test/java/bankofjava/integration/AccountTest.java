package bankofjava.integration;

import org.junit.*;
import java.util.*;
import bankofjava.domain.Account;
import bankofjava.infra.*;

public class AccountTest{

	@Before
	public void testInitialize(){
		AccountRepository accountRepository = new AccountRepository();
		for(Account account : accountRepository.getAll(Account.class))
			accountRepository.delete(account);
	}
	
	@Test
	public void createAccount(){
		AccountRepository accountRepository = new AccountRepository();
		Account account = new Account("julius@julius.com");
		accountRepository.save(account);
	}
	
	
	
}
