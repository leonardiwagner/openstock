package bankofjava.integration;

import bankofjava.domain.account.Account;
import bankofjava.infra.AccountRepository;
import bankofjava.infra.Database;

public abstract class TestHelper {
	
	public Account createTestAccount(){
		AccountRepository accountRepository = new AccountRepository(new Database());
		
		Account account = new Account();
		account = new Account("User Test Coin","test.coin@bankofjava.com","123");
		accountRepository.save(account);
		
		return account;
	}
}
