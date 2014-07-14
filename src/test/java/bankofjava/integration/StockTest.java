package bankofjava.integration;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bankofjava.domain.Account;
import bankofjava.domain.Stock;
import bankofjava.domain.StockItem;

import org.junit.*;

import bankofjava.infra.AccountRepository;
import bankofjava.infra.StockRepository;
import bankofjava.infra.YahooFinanceData;

public class StockTest {
	
	@Before
	public void testInitialize(){
		StockRepository stockRepository = new StockRepository();
		for(StockItem item : stockRepository.getAllItem())
			stockRepository.deleteItem(item);
	}

	public void insertItem(){
		StockItem stockItem = new StockItem("MSFT",)
	}
	
    public void readExchangeToday() throws IOException, URISyntaxException{
        StockRepository stockRepository = new StockRepository();
        stockRepository.getLastItem(stockName)
        List<StockItem> currencies = null;
        //currencies = stockRepository.GetExchangeDataToday();

        Assert.assertEquals(currencies.size(), 5);
    }

    @Test
    public void updateExchangeData(){
        List<StockItem> stockItemList = new ArrayList<StockItem>();
        stockItemList.add(new StockItem("CAD=X",new Date(),5));
        stockItemList.add(new StockItem("EUR=X",new Date(),10));

        StockRepository stockRepository = new StockRepository();
        stockRepository.saveItems(stockItemList);

        Stock euroStock = stockRepository.get("CAD=X");
        Stock gbpStock = stockRepository.get("EUR=X");
        
        Assert.assertEquals(5, euroStock.getCurrentValue());
        Assert.assertEquals(10, euroStock.getCurrentValue());
    }


}
