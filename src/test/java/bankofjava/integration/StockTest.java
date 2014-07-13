package bankofjava.integration;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bankofjava.domain.Stock;
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
    public void readExchangeToday() throws IOException, URISyntaxException{
        StockRepository stockRepository = new StockRepository();
        List<StockItem> currencies = null;
        currencies = stockRepository.GetExchangeDataToday();

        Assert.assertEquals(currencies.size(), 5);
    }

    @Test
    public void updateExchangeData(){
        List<StockItem> stockItemList = new ArrayList<StockItem>();
        stockItemList.add(new StockItem("EURUSD",new Date(),5));
        stockItemList.add(new StockItem("GBPUSD",new Date(),10));

        StockRepository stockRepository = new StockRepository();
        stockRepository.updateExchangeData(stockItemList);

        Stock euroStock = stockRepository.get("EURUSD");
        Stock gbpStock = stockRepository.get("GBPUSD");
        
        Assert.assertEquals(5, euroStock.getCurrentValue());
        Assert.assertEquals(10, euroStock.getCurrentValue());
    }


}
