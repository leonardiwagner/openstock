package bankofjava.integration;

import java.util.Date;

import org.junit.*;

import bankofjava.domain.Account;
import bankofjava.domain.Stock;
import bankofjava.domain.StockData;
import bankofjava.infra.AccountRepository;
import bankofjava.infra.DatabaseSession;
import bankofjava.infra.StockDataRepository;
import bankofjava.infra.StockRepository;

public class StockDataTest {
	@Test
	public void shouldCreateStockItem() throws Exception{
		try(DatabaseSession session = new DatabaseSession()){
			StockRepository repository = new StockRepository(session);
			Stock stock = new Stock("MSFT",10,0.5f);
			repository.save(stock);
			
			StockDataRepository dataRepository = new StockDataRepository(session);
			dataRepository.save(new StockData(stock, new Date(2010, 1, 1), 50, 40));
		}
	}
}
