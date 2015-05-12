package bankofjava.integration;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import bankofjava.domain.Account;
import bankofjava.domain.Stock;

import org.joda.time.DateTime;
import org.junit.*;

import bankofjava.domain.StockData;
import bankofjava.infra.database.AccountRepository;
import bankofjava.infra.database.DatabaseSession;
import bankofjava.infra.database.StockDataRepository;
import bankofjava.infra.database.StockRepository;
import bankofjava.infra.financialService.CantReadYahooFinancialDataExcepetion;
import bankofjava.infra.financialService.YahooFinancialReader;

public class YahooFinanceDataTest {
	@Test
	public void readStockDataFromYahoo() throws CantReadYahooFinancialDataExcepetion{
		YahooFinancialReader financeData = new YahooFinancialReader();
		Stock stock = new Stock("MSFT", 0, 0);
		List<StockData> stockData = financeData.get(stock, new DateTime().minusDays(3), new DateTime().minusDays(1));
		
		Assert.assertEquals(3, stockData.size());
	}
	
	public void x() throws Exception{
		try(DatabaseSession session = new DatabaseSession()){
			StockRepository stockRepository = new StockRepository(session);
			StockDataRepository stockDataRepository = new StockDataRepository(session);
			YahooFinancialReader financialReader = new YahooFinancialReader();
			
			List<Stock> stocks = stockRepository.getAll(Stock.class);
			for(Stock currentStock: stocks){
				StockData lastStockData = stockDataRepository.getLastStockData(currentStock);
				DateTime currentDate = new DateTime();
				
				List<StockData> stockDataMissing = financialReader.get(currentStock, lastStockData.getDate(), currentDate);
				for(StockData dataMissing: stockDataMissing){
					stockDataRepository.save(dataMissing);
				}
			}
			
		}
		
		
		
	}
}
