package bankofjava.infra;

import bankofjava.domain.Stock;
import bankofjava.domain.StockItem;
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
	
	private InputStream queryYahoo(String query) throws IOException, URISyntaxException{
		
		
		query = URLEncoder.encode(query);
		String queryUrl = ("https://query.yahooapis.com/v1/public/yql?q=#query#"
						+ "&format=json&diagnostics=false"
						+ "&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
						.replaceAll("#query#",query);

		URL url = new URL(queryUrl);


       return url.openStream();
	}

    public List<StockItem> GetExchangeDataToday()  throws IOException, URISyntaxException{
        //todo: check if it was already done today!
        String query = "select * from yahoo.finance.xchange where pair in "
                        + "(\"EURUSD\",\"GBPUSD\",\"CADUSD\",\"JPYUSD\", \"BRLUSD\")";

        JsonObject jsonObject = Json.createReader(this.queryYahoo(query)).readObject();

        List<StockItem> stockItemList = new ArrayList<StockItem>();
        JsonArray currencies = jsonObject.getJsonObject("query").getJsonObject("results").getJsonArray("rate");
        DateFormat formatYahooDate = new SimpleDateFormat("dd/MM/yyyy");
        for (JsonObject currency : currencies.getValuesAs(JsonObject.class)){
            try {
                stockItemList.add(new StockItem(currency.getString("id"), formatYahooDate.parse(currency.getString("Date")), Float.parseFloat(currency.getString("Rate"))));
            } catch (ParseException e) {

            }
        }
        return stockItemList;
    }

    public void updateExchangeData(List<StockItem> stockItemList){
        for(StockItem item : stockItemList){
            Stock stock = this.get(item.getName());
            stock.setCurrentValue(item.getValue());
            this.save(stock);
        }
    }

	public void GetHistoricalData(String stockName, Date start, Date end){
		/*
        String query = "select * from yahoo.finance.historicaldata where symbol = \"YHOO\" and startDate = \"2014-07-01\" and endDate = \"2014-07-10\"";
		try {
			String result = this.queryYahoo(query);
		}catch (URISyntaxException e){
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
}


