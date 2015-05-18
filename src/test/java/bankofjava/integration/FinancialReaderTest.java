package bankofjava.integration;

import org.junit.Assert;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import bankofjava.domain.Account;
import bankofjava.domain.Stock;
import bankofjava.domain.StockUpdater;

import org.joda.time.DateTime;
import org.junit.*;

import bankofjava.domain.StockData;
import bankofjava.infra.database.AccountRepository;
import bankofjava.infra.database.DatabaseSession;
import bankofjava.infra.database.StockDataRepository;
import bankofjava.infra.database.StockRepository;
import bankofjava.infra.financialService.CantReadYahooFinancialDataExcepetion;
import bankofjava.infra.financialService.YahooFinancialReader;

public class FinancialReaderTest {
	
	//@Test
	public void readStockData() throws CantReadYahooFinancialDataExcepetion{
		YahooFinancialReader financeData = new YahooFinancialReader();
		Stock stock = new Stock("MSFT", 0, 0, new DateTime());
		List<StockData> stockData = financeData.get(stock, new DateTime().minusDays(3), new DateTime().minusDays(1));
		
		Assert.assertEquals(3, stockData.size());
	}
	
	//@Test
	public void updateStockData() throws CantReadYahooFinancialDataExcepetion{
		try(DatabaseSession session = new DatabaseSession()){
			StockRepository stockRepository = new StockRepository(session);
			StockDataRepository stockDataRepository = new StockDataRepository(session);
			
			stockRepository.deleteAll(true);
			stockDataRepository.deleteAll(true);
			
			stockRepository.save(new Stock("MSFT", 0, 0, new DateTime().minusDays(3)), true);
			stockRepository.save(new Stock("KO", 0, 0, new DateTime().minusDays(2)), true);
			stockRepository.save(new Stock("MCD", 0, 0, new DateTime().minusDays(1)), true);
			
			StockUpdater stockUpdater = new StockUpdater(stockRepository, stockDataRepository, new YahooFinancialReader());
			stockUpdater.UpdateStocksData();
			
			List<StockData> stocksData = stockDataRepository.getAll();
			List<StockData> msftData = stocksData.stream().filter(p -> p.getStock().getName() == "MSFT").collect(Collectors.toList());
			List<StockData> koData = stocksData.stream().filter(p -> p.getStock().getName() == "KO").collect(Collectors.toList());
			List<StockData> mcdData = stocksData.stream().filter(p -> p.getStock().getName() == "MCD").collect(Collectors.toList());
			
			Assert.assertEquals(3, msftData.size());
			Assert.assertEquals(2, koData.size());
			Assert.assertEquals(1, mcdData.size());
		}
		
	}
	
	//@Test
	public void xuxa() throws CantReadYahooFinancialDataExcepetion{
		try(DatabaseSession session = new DatabaseSession()){
			StockRepository stockRepository = new StockRepository(session);
			@SuppressWarnings("unused")
			List<Stock> lista = stockRepository.getRisers(3);
			
			@SuppressWarnings("unused")
			int i = 1;
		}
		
	}
}
