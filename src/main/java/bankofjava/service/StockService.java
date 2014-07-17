package bankofjava.service;

import bankofjava.domain.Stock;
import bankofjava.domain.StockItem;
import bankofjava.infra.StockRepository;


import java.util.List;

public class StockService {
	
	 public void updateExchangeData(List<StockItem> stockItemList){
        StockRepository stockRepository = new StockRepository();
        //stockRepository.updateExchangeData(stockItemList);

        Stock euroStock = stockRepository.get("EURUSD");
        Stock gbpStock = stockRepository.get("GBPUSD");
        

    }

}
