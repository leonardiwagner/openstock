package bankofjava.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stock")
public class Stock {
    @Id
    private String id;
    private String name;
	private float currentValue;
	private float lastChange;
	
	public String getName(){
		return this.name;
	}
	
	public void setCurrentValue(float value){
		this.currentValue = value;
	}
	
	public void setLastChange(float lastChange){
		this.lastChange = lastChange;
	}
	
}
