package bankofjava.integration;

import org.junit.*;

import bankofjava.domain.account.Account;
import bankofjava.infra.Database;
import bankofjava.infra.Repository;

public class AccountTest {
	private Database database;
	
	@Before
	public void testInitialize()
	{
		this.database = new Database();
	}
	
	@Test
	public void createAccount()
	{
		Account account = new Account("Julius","julius@julius.com","123");
		Repository<Account> accountRepository = new Repository<Account>(this.database);
		
		accountRepository.save(account);
	}
}
