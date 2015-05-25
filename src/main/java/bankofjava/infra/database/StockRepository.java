package bankofjava.infra.database;

import bankofjava.domain.Stock;
import bankofjava.domain.StockData;
import bankofjava.domain.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;

import javax.json.*;

import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockRepository extends Repository<Stock> {

	public StockRepository(DatabaseSession session) {
		super(session, Stock.class);
	}
	
	public List<StockData> getTopRisersOfDay(DateTime date, int count){
		return getTopStocksOfDay(date, Order.asc("price"), count);
	}
	
	public List<StockData> getTopFallersOfDay(DateTime date, int count){
		return getTopStocksOfDay(date, Order.desc("price"), count);
	}
	
	
	private List<StockData> getTopStocksOfDay(DateTime date, Order order, int count){
		return session.createCriteria(StockData.class)       
                .add(Restrictions.eq("date", date))      
                .addOrder(order)
                .setMaxResults(count)
                .list();
	}
	


  


}


