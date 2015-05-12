package bankofjava.infra.financialService;

import bankofjava.domain.Stock;
import bankofjava.domain.StockData;





//import java.time.*;
import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class YahooFinancialReader {
	private final String url = "http://ichart.yahoo.com/table.csv?s=#s#&a=#a#&b=#b#&c=#c#&d=#d#&e=#e#&f=#f#&g=d&ignore=.csv";
	private final DateFormat yahooDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private final DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
	
	
	public List<StockData> get(Stock stock, DateTime startDate, DateTime endDate) throws CantReadYahooFinancialDataExcepetion{
		String callUrl = this.replaceDateUrl(startDate, endDate).replaceAll("#s#", stock.getName());
		String yahooCsvResponse;
		try {
			yahooCsvResponse = this.callYahoo(callUrl);
			return this.csvResponseToObject(yahooCsvResponse, stock);
		} catch (Exception e) {
			throw new CantReadYahooFinancialDataExcepetion(e);
		}
	}
	
	private String callYahoo(String callUrl) throws IOException {
		InputStream stream = new URL(callUrl).openStream();
		Scanner readResponse = new Scanner(stream, "UTF-8");
		String response = readResponse.useDelimiter("\\A").next();
		readResponse.close();
		stream.close();
		
		return response;
	}
	
	private List<StockData> csvResponseToObject(String csvResponse, Stock stock) throws ParseException{
		List<StockData> response = new ArrayList<StockData>();
		
		String[] lines = csvResponse.split("\n");
		for(int i = 1; i < lines.length; i++){
			String[] rows = lines[i].split(",");
			response.add(new StockData(stock, formatter.parseDateTime(rows[0]),Float.parseFloat(rows[3]),0));
		}
		
		return response;
	}
	
	private String replaceDateUrl(DateTime startDate, DateTime endDate){
		return this.url.replaceAll("#a#", String.valueOf(startDate.getMonthOfYear()))
				.replaceAll("#b#", String.valueOf(startDate.getDayOfMonth()))
				.replaceAll("#c#", String.valueOf(startDate.getYear()))
				.replaceAll("#d#", String.valueOf(endDate.getMonthOfYear()))
				.replaceAll("#e#", String.valueOf(endDate.getDayOfMonth()))
				.replaceAll("#f#", String.valueOf(endDate.getYear()));
	}
}

