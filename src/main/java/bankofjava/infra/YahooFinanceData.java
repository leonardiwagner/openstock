package bankofjava.infra;

import bankofjava.domain.StockData;

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
	private final DateFormat yahooDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public List<StockData> get(String symbol, LocalDate startDate, LocalDate endDate) throws IOException, ParseException{
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
	
	private List<StockData> csvResponseToObject(String csvResponse, String symbol) throws ParseException{
		List<StockData> response = new ArrayList<StockData>();
		
		String[] lines = csvResponse.split("\n");
		for(int i = 1; i < lines.length; i++){
			String[] rows = lines[i].split(",");
			response.add(new StockData(symbol, yahooDateFormat.parse(rows[0]),Float.parseFloat(rows[3]),0));
		}
		
		return response;
	}
	
	private String replaceDateUrl(LocalDate startDate, LocalDate endDate){
		return this.url.replaceAll("#a#", String.valueOf(startDate.getMonthValue() - 1))
				.replaceAll("#b#", String.valueOf(startDate.getDayOfMonth()))
				.replaceAll("#c#", String.valueOf(startDate.getYear()))
				.replaceAll("#d#", String.valueOf(endDate.getMonthValue() - 1))
				.replaceAll("#e#", String.valueOf(endDate.getDayOfMonth()))
				.replaceAll("#f#", String.valueOf(endDate.getYear()));
	}
}

