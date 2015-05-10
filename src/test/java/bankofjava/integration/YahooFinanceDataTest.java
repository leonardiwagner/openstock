package bankofjava.integration;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import bankofjava.domain.Stock;
import bankofjava.infra.StockRepository;
import org.junit.Assert;
import org.junit.*;

import bankofjava.domain.StockData;
import bankofjava.infra.YahooFinanceData;

public class YahooFinanceDataTest {
	@Test
	public void readStockDataFromYahoo() throws IOException, ParseException{
		YahooFinanceData financeData = new YahooFinanceData();
		List<StockData> stockData = financeData.get("MSFT", LocalDate.now().minusDays(3), LocalDate.now().minusDays(1));
		
		Assert.assertEquals(3, stockData.size());
	}
}
