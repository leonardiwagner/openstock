package bankofjava.integration;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import bankofjava.domain.StockItem;
import bankofjava.infra.YahooFinanceData;

public class YahooFinanceDataTest {
	@Test
	public void readStockDataFromYahoo() throws IOException, ParseException{
		YahooFinanceData financeData = new YahooFinanceData();
		List<StockItem> stockData = financeData.get("MSFT", LocalDate.now().minusDays(3), LocalDate.now().minusDays(1));
		
		Assert.assertEquals(2, stockData.size());
	}
}
