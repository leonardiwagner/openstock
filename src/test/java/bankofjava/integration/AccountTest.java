package bankofjava.integration;

import org.junit.*;
import java.util.*;
import bankofjava.domain.Account;
import bankofjava.domain.Coin;
import bankofjava.domain.InsufficientFundsException;
import bankofjava.infra.*;

public class AccountTest extends TestHelper{

	@Before
	public void testInitialize(){
		AccountRepository accountRepository = new AccountRepository();
		for(Account account : accountRepository.getAll(Account.class)) accountRepository.delete(account);
	}
	
	@Test
	public void createAccount(){
		AccountRepository accountRepository = new AccountRepository();
		Account account = new Account("Julius","julius@julius.com","123");
		accountRepository.save(account);
	}
	
	@Test
	public void loginAccount(){
		AccountRepository accountRepository = new AccountRepository();
		Account account = new Account("Carl", "carl@carl.com","123");
		accountRepository.save(account);
		
		Account loggedAccount = accountRepository.get("carl@carl.com", "123").get(0);
		
		Assert.assertEquals(account.getId(), loggedAccount.getId());
		Assert.assertEquals(account.getName(), loggedAccount.getName());
		Assert.assertEquals(account.getEmail(), loggedAccount.getEmail());
	}
	
	@Test
	public void depositCoins(){
		AccountRepository accountRepository = new AccountRepository();
		
		Account account = super.createTestAccount();
		List<Coin> coins = super.generateCoins(super.createTestAccount(), 20);
		account.depositCoin(coins);
		accountRepository.save(account);
		
		Account searchedAccount = accountRepository.getById(Account.class, account.getId());
		Assert.assertEquals(account.getBalance(), searchedAccount.getBalance());
	}
	
	@Test
	public void withdrawCoins() throws InsufficientFundsException{
		AccountRepository accountRepository = new AccountRepository();
		
		Account account = super.createTestAccount();
		List<Coin> coins = super.generateCoins(super.createTestAccount(), 20);
		account.depositCoin(coins);
		accountRepository.save(account);
		
		Account searchedAccount = accountRepository.getById(Account.class, account.getId());
		List<Coin> withdrawCoinList = searchedAccount.withdrawCoin(15);
		accountRepository.save(searchedAccount);
		
		Account searchedAccount2 = accountRepository.getById(Account.class, searchedAccount.getId());
		Assert.assertEquals(5, searchedAccount2.getBalance());
	}
	
	@Test
	public void withdrawCoinsWithInsufficientFunds() {
		AccountRepository accountRepository = new AccountRepository();
		
		Account account = super.createTestAccount();
		List<Coin> coins = super.generateCoins(super.createTestAccount(), 20);
		account.depositCoin(coins);
		accountRepository.save(account);
		
		Account searchedAccount = accountRepository.getById(Account.class, account.getId());
		
		try{
			List<Coin> withdrawCoinList = searchedAccount.withdrawCoin(50);
			Assert.fail("Should throw InsufficientFundsException");
		}
		catch(InsufficientFundsException e)
		{
			
		}
	}
	
}
