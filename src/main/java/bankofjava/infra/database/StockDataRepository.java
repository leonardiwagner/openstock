package bankofjava.infra.database;

import bankofjava.domain.Account;
import bankofjava.domain.Stock;
import bankofjava.domain.StockData;

import org.hibernate.Session;
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

public class StockDataRepository extends Repository<StockData> {

	public StockDataRepository(DatabaseSession session) {
		super(session, StockData.class);
	}
	
	
  

  


}


