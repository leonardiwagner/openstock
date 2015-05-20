package bankofjava.domain;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;


@Entity
@Table(name="account")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;
	private String email;
	private float balance;
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime created;
	
	protected Account(){}
	public Account(String email, float balance){
		this.email = email;
		this.balance = balance;
		this.created = new DateTime();
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public float getBalance(){
		return balance;
	}
	
	public void setBalance(float balance){
		this.balance = balance;
	}
}
