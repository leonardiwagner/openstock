package bankofjava.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name="stock")
public class Stock {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private String fullName;
	private float currentValue;
	private float lastChange;
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime lastChangeDate; 
	
	private Stock(){}
	public Stock(String name, float currentValue, float lastChange, DateTime lastChangeDate){
		this.name = name;
		this.currentValue = currentValue;
		this.lastChange = lastChange;
		this.lastChangeDate = lastChangeDate;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getFullName(){
		return this.fullName;
	}
	
	public float getLastChange(){
		return this.lastChange;
	}
	
	public DateTime getLastChangeDate(){
		return this.lastChangeDate;
	}
	
	public void setCurrentValue(float value){
		this.currentValue = value;
	}
	
	public void setLastChange(float value){
		this.lastChange = value;
	}
	
	public void setLastChangeDate(DateTime date){
		this.lastChangeDate = date;
	}

	
	
}
