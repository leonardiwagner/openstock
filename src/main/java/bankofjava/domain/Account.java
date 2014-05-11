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
	private String name;
	private String email;
	private String password;
	private int balance;
	private Date created;
	private Date deleted;
	
	@ManyToMany
	@JoinTable(	name = "account_coin", 
				joinColumns = {
								@JoinColumn(name = "accountid") },
								inverseJoinColumns = {@JoinColumn(name = "coinid")
								})
	private List<Coin> coins;
	
	public Account(){}
	public Account(String name, String email, String password){
		this.name = name;
		this.email = email;
		this.password = password;
		this.balance = 0;
		this.created = new Date();
		this.coins = new ArrayList<Coin>();
	}
	
	public void depositCoin(Coin coin){
		this.coins.add(coin);
		this.balance++;
	}
	
	public void depositCoin(List<Coin> coinList){
		for(Coin coin : coinList){
			this.coins.add(coin);
		}
		
		this.balance += coinList.size();
	}
	
	public List<Coin> withdrawCoin(int ammount) throws InsufficientFundsException{
		if(ammount > this.balance) throw new InsufficientFundsException();
		
		List<Coin> withdrawCoinList = new ArrayList<Coin>();
		for(int i=0; i < ammount; i++){
			withdrawCoinList.add(this.coins.get(0));
			this.coins.remove(0);
		}

		this.balance -= ammount;
		
		return withdrawCoinList;
	}
	
	public boolean isBank(){
		return this.email == "bank";
	}
	
	public int getBalance(){
		return balance;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	

}
