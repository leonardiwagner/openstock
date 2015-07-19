import bankofjava.domain.{StockData, Stock}
import org.joda.time.DateTime

trait StockExchangeDataReader {
  def getData(stock:Stock, startDate: DateTime, endDate: DateTime): List[StockData]
}