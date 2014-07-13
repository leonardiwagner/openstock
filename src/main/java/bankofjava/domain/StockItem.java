package bankofjava.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="stockitem")
public class StockItem {
    @Id
    private String name;
    private Date date;
    private float value;

	private StockItem(){}
	
    public StockItem(String name, Date date, float value){
        this.name = name;
        this.date = date;
        this.value = value;
    }

    public String getName(){
        return this.name;
    }

    public float getValue(){
        return this.value;
    }
}