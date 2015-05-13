package bankofjava.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name="stockdata")
public class StockData {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="stockid")
    private Stock stock;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime date;
    private float value;
    private float change;

	private StockData(){}
    public StockData(Stock stock, DateTime date, float value, float change){
        this.stock = stock;
        this.date = date;
        this.value = value;
        this.change = change;
    }
    
    public DateTime getDate(){
    	return this.date;
    }
    
    public float getValue(){
    	return this.value;
    }
    
    public void setValue(float value){
    	this.value = value;
    }
}