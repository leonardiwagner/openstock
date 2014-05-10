package bankofjava.integration;

import org.junit.*;

import bankofjava.domain.account.Account;
import bankofjava.infra.*;

import java.util.*;

public class AccountTest {
	private Database database;
	
	@Before
	public void testInitialize(){
		this.database = new Database();
		
		AccountRepository accountRepository = new AccountRepository(this.database);
		for(Account account : accountRepository.getAll(Account.class)) accountRepository.delete(account);
	}
	
	@Test
	public void createAccount(){
		AccountRepository accountRepository = new AccountRepository(this.database);
		Account account = new Account("Julius","julius@julius.com","123");
		accountRepository.save(account);
	}
	
	@Test
	public void loginAccount(){
		AccountRepository accountRepository = new AccountRepository(this.database);
		Account account = new Account("Carl", "carl@carl.com","123");
		accountRepository.save(account);
		
		Account loggedAccount = accountRepository.get("carl@carl.com", "123").get(0);
		
		Assert.assertEquals(account.getId(), loggedAccount.getId());
		Assert.assertEquals(account.getName(), loggedAccount.getName());
		Assert.assertEquals(account.getEmail(), loggedAccount.getEmail());
	}


}
