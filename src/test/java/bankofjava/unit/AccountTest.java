package bankofjava.unit;

import java.math.BigDecimal;

import org.junit.*;

import bankofjava.domain.Account;

public class AccountTest {
	
	@Test
	public void withdrawMoney()
	{
		Account account = new Account();
		account.addCoin(new BigDecimal(500));
		account.withdrawCoin(new BigDecimal(200));
		
		Assert.assertEquals(new BigDecimal(300), account.getBalance());
	}

}
