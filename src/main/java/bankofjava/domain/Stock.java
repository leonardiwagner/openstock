package bankofjava.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stock")
public class Stock {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
	private float currentValue;
	private float lastChange;
	
	private Stock(){}
	public Stock(String name, float currentValue, float lastChange){
		this.name = name;
		this.currentValue = currentValue;
		this.lastChange = lastChange;
	}
	
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
