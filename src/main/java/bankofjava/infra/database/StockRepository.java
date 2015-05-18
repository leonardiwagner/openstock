package bankofjava.infra.database;

import bankofjava.domain.Stock;
import bankofjava.domain.StockData;

import org.hibernate.Query;
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

public class StockRepository extends Repository<Stock> {

	public StockRepository(DatabaseSession session) {
		super(session, Stock.class);
	}
	
	public List<Stock> getRisers(int count){
		Query query = session.createQuery("FROM Stock ORDER BY lastChange ASC");
		query.setMaxResults(count);
		return query.list();
	}
	
	public List<Stock> getFallers(int count){
		Query query = session.createQuery("FROM Stock ORDER BY lastChange ASC");
		query.setMaxResults(count);
		return query.list();
	}
	


  


}


