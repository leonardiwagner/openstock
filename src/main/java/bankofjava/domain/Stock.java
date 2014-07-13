package bankofjava.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name="stock")
public class Stock {
    @Id
	private String name;
	private String fullName;
	private float currentValue;
	private float lastChange;
	
	public float getCurrentValue(){
		return this.currentValue;
	}
    public void setCurrentValue(float value){
        this.currentValue = value;
    }
	
}
