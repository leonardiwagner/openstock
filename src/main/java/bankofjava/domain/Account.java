package bankofjava.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="account")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;
	private String email;
	private float balance;
	private Date created;
	
	protected Account(){}
	public Account(String email){
		this.email = email;
		this.balance = 0;
		this.created = new Date();
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
