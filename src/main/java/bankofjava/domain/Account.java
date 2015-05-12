package bankofjava.domain;

import javax.persistence.*;

import org.joda.time.DateTime;


@Entity
@Table(name="account")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;
	private String email;
	private float balance;
	private DateTime created;
	
	protected Account(){}
	public Account(String email){
		this.email = email;
		this.balance = 0;
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
}
