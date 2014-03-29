package bankofjava.domain;

import java.math.BigDecimal;

public class Account {
	
	private String name;
	private BigDecimal balance = new BigDecimal(0);
	
	public void addCoin(BigDecimal coin){
		balance = this.balance.add(coin);
	}
	
	public void withdrawCoin(BigDecimal coin){
		balance = this.balance.subtract(coin);
	}
	
	public BigDecimal getBalance(){
		return balance;
	}


}
