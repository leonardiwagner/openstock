package bankofjava.infra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

public class StockRepository {
	
	private String queryYahoo(String query) throws IOException, URISyntaxException{
		
		
		query = URLEncoder.encode(query);
		String queryUrl = ("https://query.yahooapis.com/v1/public/yql?q=#query#"
						+ "&format=json&diagnostics=false"
						+ "&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
						.replaceAll("#query#",query);
		
		URL oracle = new URL(queryUrl);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
        
        return inputLine;
	}
	public void GetHistoricalData(String stockName, Date start, Date end){
		String query = "select * from yahoo.finance.historicaldata where symbol = \"YHOO\" and startDate = \"2014-07-01\" and endDate = \"2014-07-10\"";
		try {
			String result = this.queryYahoo(query);
		}catch (URISyntaxException e){
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
