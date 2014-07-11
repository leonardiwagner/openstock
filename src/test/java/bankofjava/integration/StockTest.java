package bankofjava.integration;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

import bankofjava.domain.StockItem;
import org.junit.*;

import bankofjava.infra.StockRepository;

public class StockTest {
	
	//@Test
	public void testS(){
		StockRepository stockRepository = new StockRepository();
		stockRepository.GetHistoricalData("ople", new Date(), new Date());
	}

    @Test
    public void createTestAccount(){
        StockRepository stockRepository = new StockRepository();
        List<StockItem> currencies = null;
        try {
            currencies = stockRepository.GetExchangeData();
        }catch(URISyntaxException e){

        }catch(IOException e){

        }
        Assert.assertEquals(currencies.size(), 5);
    }
}
