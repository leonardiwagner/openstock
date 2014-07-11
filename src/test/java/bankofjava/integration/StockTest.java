package bankofjava.integration;

import java.util.Date;

import org.junit.*;

import bankofjava.infra.StockRepository;

public class StockTest {
	
	@Test
	public void createTestAccount(){
		StockRepository stockRepository = new StockRepository();
		stockRepository.GetHistoricalData("ople", new Date(), new Date());
	}
}
