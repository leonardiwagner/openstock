import org.joda.time.DateTime

import scala.collection.JavaConversions._

import bankofjava.domain.{StockData, Stock}
import bankofjava.infra.database.{StockDataRepository, StockRepository}

object StockExchangeDataUpdater{
  def Update(stockRepository: StockRepository, stockDataRepository: StockDataRepository, stockDataReader: StockExchangeDataReader) = {
    stockDataRepository.beginTransaction()

    val currentDateTime = new DateTime();
    val stocks = stockRepository.getAll().toList
    stocks.foreach(s => {
      val freshStockData = stockDataReader.getData(s, s.getLastChangeDate() ,currentDateTime)
      freshStockData.foreach(stockDataRepository.save)

      val newChange = if(freshStockData.length >= 2)
        freshStockData(0).getValue - freshStockData(1).getValue
      else
        s.getLastChange - freshStockData(0).getValue

      stockRepository.save(s.changeValues(freshStockData(0).getValue, newChange, freshStockData(0).getDate))
    })

    stockDataRepository.commitTransaction()
  }
}