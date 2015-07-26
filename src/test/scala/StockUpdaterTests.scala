import bankofjava.domain.{StockData, Stock}
import bankofjava.infra.database.{StockDataRepository, StockRepository}
import org.joda.time.DateTime
import org.mockito.ArgumentCaptor
import org.mockito.Mockito._
import org.mockito.Matchers._
import org.scalatest.{FunSpec, ShouldMatchers}
import org.scalatest.mock._


class StockUpdaterTests extends FunSpec with ShouldMatchers with MockitoSugar {
  describe("StockUpdaterTests") {
    it("should update stock exchange data") {
      val stockRepositoryMock = mock[StockRepository]
      val stockDataRepositoryMock = mock[StockDataRepository]
      val stockDataServiceMock = mock[StockExchangeDataReader]

      val stock = new Stock("stock test", 50, 0, new DateTime());
      val savedStockDataList = new java.util.ArrayList[StockData]

      when(stockRepositoryMock.getAll).thenReturn(new java.util.ArrayList[Stock]{
        add(stock)
      })
      when(stockDataServiceMock.getData(any[Stock], any[DateTime], any[DateTime])).thenReturn(
        List(
          new StockData(stock,new DateTime().minusDays(1), 50,0),
          new StockData(stock,new DateTime().minusDays(2), 70,0),
          new StockData(stock,new DateTime().minusDays(3), 30,0)
        )
      )



      StockExchangeDataUpdater.Update(stockRepositoryMock, stockDataRepositoryMock, stockDataServiceMock)

      val stockCaptor = ArgumentCaptor.forClass(classOf[Stock])
      val stockDataCaptor = ArgumentCaptor.forClass(classOf[StockData])
      verify(stockRepositoryMock, times(1)).save(stockCaptor.capture())
      verify(stockDataRepositoryMock, times(3)).save(stockDataCaptor.capture())

      val savedStocks = stockCaptor.getAllValues.asInstanceOf[java.util.LinkedList[Stock]]
      savedStocks.size.should(be(1))

      val savedStocksData = stockDataCaptor.getAllValues.asInstanceOf[java.util.LinkedList[StockData]]
      savedStocksData.size.should(be(3))

      savedStocks.get(0).getLastChange.should(be(-20))
    }
  }
}