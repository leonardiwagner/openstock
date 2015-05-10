package bankofjava.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="stockdata")
public class StockData {
    @Id
    protected int id;
    private String stockId;
    private Date date;
    private float value;
    private float change;

	private StockData(){}
    public StockData(String stockId, Date date, float value, float change){
        this.stockId = stockId;
        this.date = date;
        this.value = value;
        this.change = change;
    }
}