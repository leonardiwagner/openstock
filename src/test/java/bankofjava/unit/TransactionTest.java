package bankofjava.unit;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.junit.Test;
import org.mockito.Mockito;

import bankofjava.domain.Account;
import bankofjava.domain.Stock;
import bankofjava.domain.TransactionMaker;
import bankofjava.domain.TransactionType;
import bankofjava.infra.database.AccountRepository;
import bankofjava.infra.database.TransactionRepository;
import bankofjava.domain.Transaction;

public class TransactionTest {
	
	@Test
	public void shouldMakeBuyTransaction(){
		Account account = new Account("test@account.com", 500);
		Stock stock = new Stock("MSFT", 10, 0, new DateTime());
		Transaction transaction = new Transaction(TransactionType.Buy, account, stock, 5);
		
		AccountRepository accountRepositoryMock = Mockito.mock(AccountRepository.class);
		TransactionRepository transactionRepositoryMock = Mockito.mock(TransactionRepository.class);
		TransactionMaker transactionMaker = new TransactionMaker(transactionRepositoryMock, accountRepositoryMock);
		
		transactionMaker.transact(transaction);
		
		Assert.assertEquals(450f, transaction.getAccount().getBalance());
		
	}
	
	@Test
	public void shouldMakeSellTransaction(){
		Account account = new Account("test@account.com", 500);
		Stock stock = new Stock("MSFT", 10, 0, new DateTime());
		Transaction transaction = new Transaction(TransactionType.Sell, account, stock, 5);
		
		AccountRepository accountRepositoryMock = Mockito.mock(AccountRepository.class);
		TransactionRepository transactionRepositoryMock = Mockito.mock(TransactionRepository.class);
		TransactionMaker transactionMaker = new TransactionMaker(transactionRepositoryMock, accountRepositoryMock);
		
		transactionMaker.transact(transaction);
		
		Assert.assertEquals(550f, transaction.getAccount().getBalance());
		
	}

}
