package bankofjava.controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import bankofjava.domain.Stock;
import bankofjava.domain.StockData;

public class HomeRestData {
	private Hashtable<Stock, List<StockData>> chart;
	private List<Stock> risingStocks;
	private List<Stock> fallingStocks;
	
	public HomeRestData(){
		chart = new Hashtable<Stock, List<StockData>>();
		risingStocks = new ArrayList<Stock>();
		fallingStocks = new ArrayList<Stock>();
	}
	
	public Hashtable<Stock, List<StockData>> getChart(){
		return this.chart;
	}
	
	public List<Stock> getRisingStocks(){
		return this.risingStocks;
	}
	
	public List<Stock> getFallingStocks(){
		return this.fallingStocks;
	}
}
