package bankofjava.integration;

import java.math.BigDecimal;

import bankofjava.domain.*;
import bankofjava.domain.account.*;
import bankofjava.infra.*;

import org.junit.*;

public class CoinTest {
	
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
	public void testCreateCoin(){
		Repository<Coin> coinRepository = new Repository<Coin>(this.database);
		
		Coin coin = new Coin(account, "192.0.0.1");
		coinRepository.save(coin);
	}
}
