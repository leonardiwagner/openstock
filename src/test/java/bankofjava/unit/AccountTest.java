package bankofjava.unit;

import java.math.BigDecimal;

import org.junit.*;

import bankofjava.domain.Account;
import bankofjava.infra.AccountRepository;

public class AccountTest {
	
	@Test
	public void withdrawMoney()
	{
		Account account = new Account();
		account.addCoin(new BigDecimal(500));
		account.withdrawCoin(new BigDecimal(200));
		
		Assert.assertEquals(new BigDecimal(300), account.getBalance());
	}
	
	@Test
	public void createAccount(){
		Account account = new Account("Roberto Baggio", "wagner@wagner.com", "123");
		AccountRepository repository = new AccountRepository();
		
		repository.insert(account);
		
	}

}
