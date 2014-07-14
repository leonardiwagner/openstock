package bankofjava.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;

import bankofjava.domain.Stock;
import bankofjava.domain.StockItem;
import bankofjava.infra.StockRepository;

public class StockService {
	
	 public void updateExchangeData(List<StockItem> stockItemList){
        StockRepository stockRepository = new StockRepository();
        //stockRepository.updateExchangeData(stockItemList);

        Stock euroStock = stockRepository.get("EURUSD");
        Stock gbpStock = stockRepository.get("GBPUSD");
        
        Assert.assertEquals(5, euroStock.getCurrentValue());
        Assert.assertEquals(10, euroStock.getCurrentValue());
    }

}
