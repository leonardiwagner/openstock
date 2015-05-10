package bankofjava.infra;

import bankofjava.domain.Stock;
import bankofjava.domain.StockData;
import org.hibernate.Session;

import javax.json.*;
import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockRepository {
    private Session databaseSession;

    public StockRepository(){
        this.databaseSession = Database.getOpenSession();
    }

    public Stock get(String name){
        return (Stock) databaseSession.get(Stock.class,name);
    }

    private Stock save(Stock stock){
        databaseSession.beginTransaction();
        databaseSession.saveOrUpdate(stock);
        databaseSession.getTransaction().commit();
        return stock;
    }
	
    public void saveItems(List<StockData> stockItemList){
        for(StockData item : stockItemList){
          //  Stock stock = this.get(item.getName());
          //  stock.setCurrentValue(item.getValue());
         //   this.save(stock);
        }
    }
    
    public void deleteItem(StockData entity){
    	databaseSession.beginTransaction();
    	databaseSession.delete(entity);
		databaseSession.getTransaction().commit();
	}
    
    public StockData getLastItem(String stockName){
    	return (StockData)this.databaseSession.createQuery("from StockItem where name='" + stockName + "' order by date desc LIMIT 1").uniqueResult();
    }


}


