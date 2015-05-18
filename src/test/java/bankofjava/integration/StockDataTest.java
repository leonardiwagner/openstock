package bankofjava.integration;

import java.util.Date;

import org.joda.time.DateTime;
import org.junit.*;

import bankofjava.domain.Account;
import bankofjava.domain.Stock;
import bankofjava.domain.StockData;
import bankofjava.infra.database.AccountRepository;
import bankofjava.infra.database.DatabaseSession;
import bankofjava.infra.database.StockDataRepository;
import bankofjava.infra.database.StockRepository;

public class StockDataTest {
	//@Test
	public void shouldCreateStockItem() throws Exception{
		try(DatabaseSession session = new DatabaseSession()){
			StockRepository repository = new StockRepository(session);
			Stock stock = new Stock("MSFT",10,0.5f, new DateTime());
			repository.save(stock);
			
			StockDataRepository dataRepository = new StockDataRepository(session);
			dataRepository.save(new StockData(stock, new DateTime(), 50, 40));
		}
	}
}
