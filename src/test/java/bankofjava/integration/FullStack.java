package bankofjava.integration;

import org.junit.Assert;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

import bankofjava.domain.Account;
import bankofjava.domain.Stock;
import bankofjava.domain.StockUpdater;
import bankofjava.domain.Transaction;
import bankofjava.domain.TransactionMaker;
import bankofjava.domain.TransactionType;

import org.joda.time.DateTime;
import org.junit.*;

import bankofjava.domain.StockData;
import bankofjava.infra.database.TransactionRepository;
import bankofjava.infra.database.AccountRepository;
import bankofjava.infra.database.DatabaseSession;
import bankofjava.infra.database.StockDataRepository;
import bankofjava.infra.database.StockRepository;
import bankofjava.infra.financialService.CantReadYahooFinancialDataExcepetion;
import bankofjava.infra.financialService.YahooFinancialReader;

public class FullStack {
	
	@Test
	public void testX(){
		try(DatabaseSession session = new DatabaseSession()){
			TransactionRepository transaction = new TransactionRepository(session);
			transaction.mostSelledToday();
			
			/*
			for(Stock s : stockList){
				System.out.println(s.getName());
			}*/
			
			int x = 2;
		}
	}
	
	//@Test
	public void fullStack() throws CantReadYahooFinancialDataExcepetion{
		try(DatabaseSession session = new DatabaseSession()){
			
			List<Account> accountList = new ArrayList<Account>();
			accountList.add(new Account("teste1@user.com", 600));
			accountList.add(new Account("teste2@user.com", 600));
			accountList.add(new Account("teste3@user.com", 600));
			accountList.add(new Account("teste4@user.com", 600));
			accountList.add(new Account("teste5@user.com", 600));
			
			List<Stock> stockList = new ArrayList<Stock>();
			stockList.add(new Stock("MSFT", 10, 0, new DateTime().minusDays(8)));
			stockList.add(new Stock("KO", 40, 0, new DateTime().minusDays(8)));
			stockList.add(new Stock("PBR", 30, 0, new DateTime().minusDays(8)));
			stockList.add(new Stock("BAC", 60, 0, new DateTime().minusDays(8)));
			stockList.add(new Stock("MCD", 70, 0, new DateTime().minusDays(8)));
			
			AccountRepository accountRepository = new AccountRepository(session);
			StockRepository stockRepository = new StockRepository(session);
			StockDataRepository stockDataRepository = new StockDataRepository(session);
			TransactionRepository transactionRepository = new TransactionRepository(session);
			
			transactionRepository.deleteAll(true);
			stockDataRepository.deleteAll(true);
			stockRepository.deleteAll(true);
			accountRepository.deleteAll(true);
			
			
			accountList.stream().forEach(x -> accountRepository.save(x, true));
			stockList.stream().forEach(x -> stockRepository.save(x, true));
			
			StockUpdater stockUpdater = new StockUpdater(stockRepository, stockDataRepository, new YahooFinancialReader());
			stockUpdater.UpdateStocksData();
			
			TransactionMaker transactionMaker = new TransactionMaker(transactionRepository, accountRepository);
			transactionMaker.transact(new Transaction(TransactionType.Buy, accountList.get(0), stockList.get(0), 10));
			transactionMaker.transact(new Transaction(TransactionType.Buy, accountList.get(1), stockList.get(0), 30));
			transactionMaker.transact(new Transaction(TransactionType.Buy, accountList.get(2), stockList.get(0), 20));
			transactionMaker.transact(new Transaction(TransactionType.Buy, accountList.get(1), stockList.get(1), 15));
			transactionMaker.transact(new Transaction(TransactionType.Buy, accountList.get(3), stockList.get(1), 2));
			transactionMaker.transact(new Transaction(TransactionType.Buy, accountList.get(4), stockList.get(1), 3));
			transactionMaker.transact(new Transaction(TransactionType.Buy, accountList.get(0), stockList.get(2), 7));
			transactionMaker.transact(new Transaction(TransactionType.Buy, accountList.get(2), stockList.get(3), 8));
			transactionMaker.transact(new Transaction(TransactionType.Buy, accountList.get(4), stockList.get(4), 10));
			
			transactionMaker.transact(new Transaction(TransactionType.Sell, accountList.get(2), stockList.get(3), 10));
			transactionMaker.transact(new Transaction(TransactionType.Sell, accountList.get(4), stockList.get(2), 30));
			transactionMaker.transact(new Transaction(TransactionType.Sell, accountList.get(3), stockList.get(4), 20));
			transactionMaker.transact(new Transaction(TransactionType.Sell, accountList.get(1), stockList.get(0), 15));
			transactionMaker.transact(new Transaction(TransactionType.Sell, accountList.get(0), stockList.get(3), 2));
			transactionMaker.transact(new Transaction(TransactionType.Sell, accountList.get(3), stockList.get(4), 3));
			transactionMaker.transact(new Transaction(TransactionType.Sell, accountList.get(0), stockList.get(3), 7));
			transactionMaker.transact(new Transaction(TransactionType.Sell, accountList.get(1), stockList.get(2), 8));
			transactionMaker.transact(new Transaction(TransactionType.Sell, accountList.get(2), stockList.get(2), 10));
		}
		
	}
	
}
