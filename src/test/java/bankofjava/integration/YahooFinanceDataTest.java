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
	
	public void readStockDataFromYahoo() throws CantReadYahooFinancialDataExcepetion{
		YahooFinancialReader financeData = new YahooFinancialReader();
		Stock stock = new Stock("MSFT", 0, 0, new DateTime());
		List<StockData> stockData = financeData.get(stock, new DateTime().minusDays(3), new DateTime().minusDays(1));
		
		Assert.assertEquals(3, stockData.size());
	}
	@Test
	public void updateStockData() throws Exception{
		try(DatabaseSession session = new DatabaseSession()){
			StockRepository stockRepository = new StockRepository(session);
			StockDataRepository stockDataRepository = new StockDataRepository(session);
			YahooFinancialReader financialReader = new YahooFinancialReader();
			
			List<Stock> stocks = stockRepository.getAll();
			for(Stock currentStock: stocks){
				DateTime currentDate = new DateTime();
				List<StockData> stockDataMissing = financialReader.get(currentStock, currentStock.getLastChangeDate(), currentDate);
				if(stockDataMissing.size() > 0){
					for(StockData dataMissing: stockDataMissing){
						stockDataRepository.save(dataMissing);
					}
					
					float newChange;
					if(stockDataMissing.size() >= 2){
						newChange = stockDataMissing.get(stockDataMissing.size() -1).getValue() - stockDataMissing.get(stockDataMissing.size() -2).getValue();
					}else{
						newChange = currentStock.getLastChange() - stockDataMissing.get(stockDataMissing.size() -1).getValue();
					}
					
					currentStock.setCurrentValue(stockDataMissing.get(stockDataMissing.size() -1).getValue());
					currentStock.setLastChange(newChange);
					currentStock.setLastChangeDate(currentDate);
					stockRepository.save(currentStock);
				}
			}
			
		}
		
		
		
	}
}
