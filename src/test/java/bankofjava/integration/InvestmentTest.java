package bankofjava.integration;

import org.junit.Before;
import org.junit.Test;

import bankofjava.domain.*;
import bankofjava.domain.account.*;
import bankofjava.domain.investment.Investment;
import bankofjava.infra.*;
import junit.*;

public class InvestmentTest {

	private Database database;
	private Account account;
	
	@Before
	public void testInitialize()
	{
		this.database = new Database();
		
		Repository<Account> accountRepository = new Repository<Account>(this.database);
		this.account = new Account("User Test Coin","test.coin@bankofjava.com","123");
		accountRepository.save(account);
	}
	
	@Test
	public void createInvestment(){
		
	}
}
