package bankofjava.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name="stockdata")
public class StockData {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="stockid")
    private Stock stock;
    private Date date;
    private float value;
    private float change;

	private StockData(){}
    public StockData(Stock stock, Date date, float value, float change){
        this.stock = stock;
        this.date = date;
        this.value = value;
        this.change = change;
    }
}