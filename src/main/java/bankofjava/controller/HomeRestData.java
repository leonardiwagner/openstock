package bankofjava.controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import bankofjava.domain.Stock;
import bankofjava.domain.StockData;

public class HomeRestData {
	public Hashtable<Stock, List<StockData>> chart;
	public List<Stock> risingStocks;
	public List<Stock> fallingStocks;
	
	public HomeRestData(){
		chart = new Hashtable<Stock, List<StockData>>();
		risingStocks = new ArrayList<Stock>();
		fallingStocks = new ArrayList<Stock>();
	}
}
