package bankofjava.integration;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.junit.*;

import bankofjava.domain.Account;
import bankofjava.domain.Stock;
import bankofjava.domain.StockData;
import bankofjava.domain.StockUpdater;
import bankofjava.domain.Transaction;
import bankofjava.domain.TransactionType;
import bankofjava.infra.database.AccountRepository;
import bankofjava.infra.database.DatabaseSession;
import bankofjava.infra.database.StockDataRepository;
import bankofjava.infra.database.StockRepository;
import bankofjava.infra.database.TransactionRepository;
import bankofjava.infra.financialService.YahooFinancialReader;

public class TransactionTest {
	@Test
	public void shouldCreateTransaction() throws Exception{
		try(DatabaseSession session = new DatabaseSession()){
			AccountRepository accountRepository = new AccountRepository(session);
			StockRepository stockRepository = new StockRepository(session);
			StockDataRepository stockDataRepository = new StockDataRepository(session);
			TransactionRepository transactionRepository = new TransactionRepository(session);
			
			accountRepository.deleteAll(true);
			stockDataRepository.deleteAll(true);
			stockRepository.deleteAll(true);
			transactionRepository.deleteAll(true);
			
			Account account = new Account("test@user.com", 500);
			Stock stock = new Stock("MSFT", 100, 0, new DateTime().minusDays(13));
			accountRepository.save(account, true);
			stockRepository.save(stock, true);
			
			Transaction transaction = new Transaction(TransactionType.Buy, account, stock, 3);
			transaction.transact(transactionRepository, accountRepository);
						
			List<Transaction> transactionData = transactionRepository.getAll();
			
			float x = 1;
			//Assert.assertEquals(3, msftData.size());
			//Assert.assertEquals(2, koData.size());
			//Assert.assertEquals(1, mcdData.size());
		}
	}
}
