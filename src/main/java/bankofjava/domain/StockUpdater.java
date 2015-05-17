package bankofjava.domain;

import java.util.List;

import org.joda.time.DateTime;

import bankofjava.infra.database.DatabaseSession;
import bankofjava.infra.database.StockDataRepository;
import bankofjava.infra.database.StockRepository;
import bankofjava.infra.financialService.CantReadYahooFinancialDataExcepetion;
import bankofjava.infra.financialService.YahooFinancialReader;

public class StockUpdater {
	private final StockRepository stockRepository;
	private final StockDataRepository stockDataRepository;
	private final YahooFinancialReader financialReader;
	
	public StockUpdater(StockRepository stockRepository, StockDataRepository stockDataRepository, YahooFinancialReader financialReader){
		this.stockRepository = stockRepository;
		this.stockDataRepository = stockDataRepository;
		this.financialReader = financialReader;
	}
	
	public void UpdateStocksData() throws CantReadYahooFinancialDataExcepetion{
		List<Stock> stocks = stockRepository.getAll();
		stockRepository.beginTransaction();
		for(Stock currentStock: stocks){
			UpdateStockData(currentStock);
		}
		stockRepository.commitTransaction();
	}
	
	private void UpdateStockData(Stock stock) throws CantReadYahooFinancialDataExcepetion{
		DateTime currentDate = new DateTime();
		List<StockData> stockDataMissing = financialReader.get(stock, stock.getLastChangeDate(), currentDate);
		if(stockDataMissing.size() > 0){
			SaveMissingStockData(stock, stockDataMissing);
		}
	}
	
	private void SaveMissingStockData(Stock stock, List<StockData> stockDataMissing){
		for(StockData dataMissing: stockDataMissing){
			stockDataRepository.save(dataMissing);
		}
		
		float newChange;
		if(stockDataMissing.size() >= 2){
			newChange = stockDataMissing.get(stockDataMissing.size() -1).getValue() - stockDataMissing.get(stockDataMissing.size() -2).getValue();
		}else{
			newChange = stock.getLastChange() - stockDataMissing.get(stockDataMissing.size() -1).getValue();
		}
		
		DateTime currentDate = new DateTime();
		stock.setLastChangeDate(currentDate);
		stock.setLastChange(newChange);
		stock.setCurrentValue(stockDataMissing.get(stockDataMissing.size() -1).getValue());
		stockRepository.save(stock);
	}
}
