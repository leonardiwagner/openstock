package bankofjava.infra;

import bankofjava.domain.StockItem;

import java.time.*;

import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YahooFinanceData {
	private final String url = "http://ichart.yahoo.com/table.csv?s=#s#&a=#a#&b=#b#&c=#c#&d=#d#&e=#e#&f=#f#&g=d&ignore=.csv";
	private final DateFormat yahooDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public List<StockItem> get(String symbol, LocalDate startDate, LocalDate endDate) throws IOException, ParseException{
		String callUrl = this.replaceDateUrl(startDate, endDate).replaceAll("#s#", symbol);
		String yahooCsvResponse = this.callYahoo(callUrl);
		return this.csvResponseToObject(yahooCsvResponse, symbol);
	}
	
	private String callYahoo(String callUrl) throws IOException {
		InputStream stream = new URL(callUrl).openStream();
		Scanner readResponse = new Scanner(stream, "UTF-8");
		String response = readResponse.useDelimiter("\\A").next();
		readResponse.close();
		stream.close();
		
		return response;
	}
	
	private List<StockItem> csvResponseToObject(String csvResponse, String symbol) throws ParseException{
		List<StockItem> response = new ArrayList<StockItem>();
		
		String[] lines = csvResponse.split("/r");
		for(int i = 1; i < lines.length; i++){
			String[] rows = lines[i].split(",");
			response.add(new StockItem(symbol, yahooDateFormat.parse(rows[0]),Float.parseFloat(rows[3])));
		}
		
		return response;
	}
	
	private String replaceDateUrl(LocalDate startDate, LocalDate endDate){
		return this.url.replaceAll("#a#", String.valueOf(startDate.getDayOfMonth()))
				.replaceAll("#b#", String.valueOf(startDate.getMonthValue()))
				.replaceAll("#c#", String.valueOf(startDate.getYear()))
				.replaceAll("#d#", String.valueOf(startDate.getDayOfMonth()))
				.replaceAll("#e#", String.valueOf(startDate.getMonthValue()))
				.replaceAll("#f#", String.valueOf(startDate.getYear()));
	}
}

