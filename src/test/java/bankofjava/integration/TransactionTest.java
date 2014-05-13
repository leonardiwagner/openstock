package bankofjava.integration;

import org.junit.*;
import bankofjava.domain.Account;
import bankofjava.domain.InsufficientFundsException;
import bankofjava.domain.Transfer;
import bankofjava.infra.AccountRepository;
import bankofjava.service.TransactionService;

public class TransactionTest extends TestHelper {

	@Test
	public void transaction() throws InsufficientFundsException{
		AccountRepository accountRepository = new AccountRepository();
		
		Account accountA = super.createTestAccount();
		Account accountB = super.createTestAccount();
		
		accountA.depositCoin(super.generateCoins(accountA, 30));
		accountRepository.save(accountA);
		
		TransactionService transaction = new TransactionService();
		Transfer transfer = transaction.transfer(accountA, accountB, 20);
		
		Account searchedAccountA = accountRepository.getById(Account.class, accountA.getId());
		Account searchedAccountB = accountRepository.getById(Account.class, accountB.getId());
		
		Assert.assertEquals(10, accountA.getBalance());
		Assert.assertEquals(20, accountB.getBalance());
		Assert.assertEquals(accountA.getId(), transfer.getAccountFrom().getId());
		Assert.assertEquals(accountB.getId(), transfer.getAccountTo().getId());
		Assert.assertEquals(20, transfer.getAmount());
	}
	
	@Test
	public void transactionWithInsufficientFunds(){
		AccountRepository accountRepository = new AccountRepository();
		
		Account accountA = super.createTestAccount();
		Account accountB = super.createTestAccount();
		
		accountA.depositCoin(super.generateCoins(accountA, 30));
		accountRepository.save(accountA);
		
		TransactionService transaction = new TransactionService();
		
		try{
			Transfer transfer = transaction.transfer(accountA, accountB, 50);
			Assert.fail("Should throw InsufficientFundsException");
		}catch(InsufficientFundsException e){
			
		}
	}
}
