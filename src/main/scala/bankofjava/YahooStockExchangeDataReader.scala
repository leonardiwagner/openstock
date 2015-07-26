import java.text.{ParseException, SimpleDateFormat, DateFormat}

import bankofjava.domain.{StockData, Stock}
import org.joda.time.DateTime
import org.joda.time.format.{DateTimeFormat, DateTimeFormatter}

import scala.io.Source

object YahooStockExchangeDataReader extends StockExchangeDataReader {
  private val url = "http://ichart.yahoo.com/table.csv?s=#s#&a=#a#&b=#b#&c=#c#&d=#d#&e=#e#&f=#f#&g=d&ignore=.csv"
  private val yahooDateFormat = new SimpleDateFormat("yyyy-MM-dd")
  private val formatter = DateTimeFormat.forPattern("yyyy-MM-dd")

  def getData(stock:Stock, startDate: DateTime, endDate: DateTime): List[StockData] ={
    val callUrl = this.replaceDateUrl(startDate, endDate)
    val csvResponse = Source.fromURL(callUrl).mkString
    csvResponseToObjectList(csvResponse, stock).reverse //reverse to newest be the first
  }

  private def replaceDateUrl(startDate: DateTime, endDate: DateTime): String = {
    this.url.replaceAll("#a#", String.valueOf(startDate.getMonthOfYear() - 1))
      .replaceAll("#b#", String.valueOf(startDate.getDayOfMonth() ))
      .replaceAll("#c#", String.valueOf(startDate.getYear()))
      .replaceAll("#d#", String.valueOf(endDate.getMonthOfYear() - 1))
      .replaceAll("#e#", String.valueOf(endDate.getDayOfMonth()))
      .replaceAll("#f#", String.valueOf(endDate.getYear()))
  }

  private def csvResponseToObjectList(csvResponse: String, stock: Stock): List[StockData] = {
    val lines = csvResponse.split("\n").toList

    lines.map((line:String) => {
      val rows = line.split(",")
      new StockData(stock, formatter.parseDateTime(rows(0)), rows(3).toFloat, 0)
    })
  }
}